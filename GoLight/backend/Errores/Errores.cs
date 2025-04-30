// Clase para representar un error
public class Error {
    public string Tipo { get; set; }
    public string Descripcion { get; set; }
    public int Linea { get; set; }
    public int Columna { get; set; }

    public Error(string tipo, string descripcion, int linea, int columna) {
        Tipo = tipo;
        Descripcion = descripcion;
        Linea = linea;
        Columna = columna;
    }

    public override string ToString() {
        return $"\n[{Tipo}] {Descripcion} (Línea {Linea}, Columna {Columna})\n";
    }
}

// Clase para manejar los errores
public class Errores {
    private List<Error> errores = new List<Error>();

    public void setError(string tipo, string descripcion, int linea, int columna) {
        errores.Add(new Error(tipo, descripcion, linea, columna));
    }

    public string MostrarErrores() {
        foreach (var error in errores) {
            error.ToString();
            Console.WriteLine(error.ToString());
        }
        return "";
    }

    public List<Error> ObtenerErrores() {
        return errores;
    }

}
