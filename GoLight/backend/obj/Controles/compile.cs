using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace GoLight.obj.Controles
{
    [Route("[controller]")]
    public class compile : Controller
    {
        private readonly ILogger<compile> _logger;

        public compile(ILogger<compile> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View("Error!");
        }
        public class CompileRequest
        {
            [Required]
            public required string Code { get; set; }
        }
        
        [HttpPost]
        public async Task<IActionResult> Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _logger.LogInformation("Compiling code: {0}", request.Code);

            var inputStream = new AntlrInputStream(request.Code);
            var lexer = new LanguageLexer(inputStream);
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new LanguageParser(tokenStream);
            var tree = parser.expr();

            var visitor = new CompilerVisitor();
            var result = visitor.Visit(tree);

            return Ok(result);
        }
    }
}