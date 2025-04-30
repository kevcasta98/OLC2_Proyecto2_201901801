/*public class Instancia {
    public LenguageClass lenguageClass;
    public Dictionary<string, ValueWrapper> campos;

    public Instancia(LenguageClass lenguageClass) {
        this.lenguageClass = lenguageClass;
        campos = new Dictionary<string, ValueWrapper>();
    }
    public void SetCampo(string nombre, ValueWrapper valor) {        
        Console.WriteLine($"SetCampo {nombre} {valor}");
        campos[nombre] = valor;

    }
    public void UpdateCampo(string nombre,string pos , ValueWrapper valor) {
        if (campos.ContainsKey(nombre)) {
            campos[pos] = valor;
            return;
        }
        throw new Exception($"No se encontro el campo {nombre}");
    }
    public ValueWrapper GetCampo(string nombre, Antlr4.Runtime.IToken token) {
        if (campos.ContainsKey(nombre)) {
            return campos[nombre];
        }
        var metodo = lenguageClass.GetMethod(nombre);
        if (metodo != null) {
            return new FunctionValue(metodo.Bind(this), nombre);
        }

        throw new Exception($"No se encontro el campo {nombre}");
    }

}*/