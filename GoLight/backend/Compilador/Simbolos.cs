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
}
