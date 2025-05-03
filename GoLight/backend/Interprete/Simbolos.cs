using System.Text;

// Clase para representar un símbolo en la tabla de símbolos
public class Simbolo {
    public string ID { get; set; }           // Nombre del símbolo
    public string TipoSimbolo { get; set; }  // Tipo de símbolo (variable, función, etc.)
    public string TipoDato { get; set; }     // Tipo de dato (int, string, bool, etc.)
    public string Ambito { get; set; }       // Ámbito donde se declara
    public int Linea { get; set; }           // Línea de declaración
    public int Columna { get; set; }         // Columna de declaración

    public Simbolo(string id, string tipoSimbolo, string tipoDato, string ambito, int linea, int columna) {
        ID = id;
        TipoSimbolo = tipoSimbolo;
        TipoDato = tipoDato;
        Ambito = ambito;
        Linea = linea;
        Columna = columna;
    }

    public override string ToString() {
        return $"ID: {ID}, Tipo: {TipoSimbolo}, Dato: {TipoDato}, Ámbito: {Ambito}, Línea: {Linea}, Columna: {Columna}";
    }
}

// Clase para manejar la tabla de símbolos


public class TablaSimbolos {
    private List<Simbolo> simbolos = new List<Simbolo>();

    public void AgregarSimbolo(string id, string tipoSimbolo, string tipoDato, string ambito, int linea, int columna) {
        simbolos.Add(new Simbolo(id, tipoSimbolo, tipoDato, ambito, linea, columna));
    }

    public string MostrarSimbolos() {
        if (simbolos.Count == 0) return "La tabla de símbolos está vacía.";

        StringBuilder sb = new StringBuilder();
        sb.AppendLine("Tabla de Símbolos:");
        sb.AppendLine("-------------------------------------------------");

        foreach (var simbolo in simbolos) {
            sb.AppendLine(simbolo.ToString());
        }

        return sb.ToString();
    }

    public List<Simbolo> ObtenerSimbolos() {
        return simbolos;
    }
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
