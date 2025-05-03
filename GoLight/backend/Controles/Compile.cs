using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace Controllers
{
    [Route("[controller]")]
    public class Compile : Controller
    {
        private readonly ILogger<Compile> _logger;
        private static List<Error> tablaErrores = new List<Error>();
        private static List<Simbolo> simbolos = new List<Simbolo>();


        public Compile(ILogger<Compile> logger)
        {
            _logger = logger;
        }

        public class CompileRequest
        {
            [Required]
            public required string code { get; set; }
        }
        // GET /compile/symbols
        /*[HttpGet("symbols")]
        public IActionResult GetSymbols()
        {
            var visitor = new CompiladorVisitor();
            return Ok(new { symbols = visitor.tablaSimbolos.ObtenerSimbolos() });
        }*/


        // POST /compile
        [HttpPost]
        public IActionResult Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid request" });
            }

            var inputStream = new AntlrInputStream(request.code);
            var lexer = new AnalizadorLexer(inputStream);


            var tokens = new CommonTokenStream(lexer);
            var parser = new AnalizadorParser(tokens);
            

            try
            {
                var tree = parser.program();

                var interprete = new InterpreteVisitor();
                interprete.Visit(tree);
                tablaErrores = interprete.errores.ObtenerErrores();

                var compi = new CompiladorVisitor();
                compi.Visit(tree);


                //Console.WriteLine(Ok(new { symbols = visitor.tablaSimbolos.MostrarSimbolos() }));

                return Ok(new
                {
                    interprete = tablaErrores,
                    result = compi.codigo.ToString(),
                
                });
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }

        }


        [HttpPost("ast")]
        public IActionResult GenerarDesdeGet([FromQuery] string code)
        {
            if (string.IsNullOrEmpty(code))
            {
                return BadRequest(new { error = "El código está vacío." });
            }

            var inputStream = new AntlrInputStream(code);
            var lexer = new AnalizadorLexer(inputStream);
            var tokens = new CommonTokenStream(lexer);
            var parser = new AnalizadorParser(tokens);

            try
            {
                var tree = parser.program();

                var interprete = new InterpreteVisitor();
                interprete.Visit(tree);
                tablaErrores = interprete.errores.ObtenerErrores();

                var compi = new CompiladorVisitor();
                compi.Visit(tree);

                return Ok(new
                {
                    interprete = tablaErrores,
                    result = compi.codigo.ToString(),
                });
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }
        }
                

        /*public async Task<IActionResult> GetAst([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid request" });
            }

            string grammarPath = Path.Combine(Directory.GetCurrentDirectory(), "Gramatica/Analizador.g4");
            var grammar = "";

            try
            {
                if (System.IO.File.Exists(grammarPath))
                {
                    grammar = await System.IO.File.ReadAllTextAsync(grammarPath);
                }
                else
                {
                    return BadRequest(new { error = "Grammar file not found" });
                }
            }
            catch (System.Exception)
            {
                return BadRequest(new { error = "Error leer la gramatica" });
            }



            var payload = new
            {
                grammar,
                input = request.code,
                lexgrammar = "",
                start = "program"
            };


            var JsonPayload = JsonSerializer.Serialize(payload);
            var context = new StringContent(JsonPayload, Encoding.UTF8, "application/json");

            using (var client = new HttpClient())
            {
                try
                {

                    HttpResponseMessage response = await client.PostAsync("http://lab.antlr.org/parse/", context);
                    response.EnsureSuccessStatusCode();

                    string result = await response.Content.ReadAsStringAsync();
                    using var doc = JsonDocument.Parse(result);
                    var root = doc.RootElement;

                    if (root.TryGetProperty("result", out JsonElement resultElement) && resultElement.TryGetProperty("svgtree", out JsonElement svgElement))
                    {
                        string svgtree = svgElement.GetString() ?? string.Empty;
                        return Content(svgtree, "image/svg+xml");
                    }

                    return BadRequest(new { error = "Error al obtener el arbol" });


                }
                catch (System.Exception)
                {
                    return BadRequest(new { error = "Error al conectar con el servidor" });
                }


            }

           

        }*/
        [HttpGet("errores")]
        public IActionResult GetErrores()
        {

            var htmlBuilder = new StringBuilder();

            htmlBuilder.Append("<html><head>");
            htmlBuilder.Append("<meta charset=\"UTF-8\">");
            htmlBuilder.Append("<style>");
            htmlBuilder.Append("table { border-collapse: collapse; width: 100%; }");
            htmlBuilder.Append("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
            htmlBuilder.Append("th { background-color: #f2f2f2; }");
            htmlBuilder.Append("</style>");
            htmlBuilder.Append("</head><body>");

            htmlBuilder.Append("<h2>Tabla de Errores</h2>");
            htmlBuilder.Append("<table>");
            htmlBuilder.Append("<tr><th>#</th><th>Descripción</th></tr>");

            for (int i = 0; i < tablaErrores.Count; i++)
            {
                htmlBuilder.Append($"<tr><td>{i + 1}</td><td>{tablaErrores[i]}</td></tr>");
            }

            htmlBuilder.Append("</table>");
            htmlBuilder.Append("</body></html>");

            return new ContentResult
            {
                Content = htmlBuilder.ToString(),
                ContentType = "text/html"
            };
        }
        [HttpGet("Simbolos")]
        public string GenerarHTMLTablaSimbolos()
{
            if (simbolos.Count == 0) return "<p>No se encontraron símbolos.</p>";

            StringBuilder html = new StringBuilder();

            html.Append("<table border='1' style='border-collapse: collapse; width: 100%; text-align: center;'>");
            html.Append("<thead style='background-color: #4CAF50; color: white;'>");
            html.Append("<tr>");
            html.Append("<th>ID</th>");
            html.Append("<th>Tipo de Símbolo</th>");
            html.Append("<th>Tipo de Dato</th>");
            html.Append("<th>Ámbito</th>");
            html.Append("<th>Línea</th>");
            html.Append("<th>Columna</th>");
            html.Append("</tr>");
            html.Append("</thead>");
            html.Append("<tbody>");

            foreach (var simbolo in simbolos)
            {
                html.Append("<tr>");
                html.AppendFormat("<td>{0}</td>", simbolo.ID);
                html.AppendFormat("<td>{0}</td>", simbolo.TipoSimbolo);
                html.AppendFormat("<td>{0}</td>", simbolo.TipoDato);
                html.AppendFormat("<td>{0}</td>", simbolo.Ambito);
                html.AppendFormat("<td>{0}</td>", simbolo.Linea);
                html.AppendFormat("<td>{0}</td>", simbolo.Columna);
                html.Append("</tr>");
            }

            html.Append("</tbody>");
            html.Append("</table>");

            return html.ToString();
}

    }
}