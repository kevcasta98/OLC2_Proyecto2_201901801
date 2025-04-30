/*using analyzer;

public class LanguageSlice : Argumentos{
    public string nombre { get; set; }
    public Dictionary<string, AnalizadorParser.VarDclContext> Props { get; }
    public Dictionary<string, FuncionesForaneas> Metodos { get; set; }
    private LenguageClass ClaseEquivalente;

    public LanguageSlice(){
        Props = new Dictionary<string, AnalizadorParser.VarDclContext>();
        Metodos = new Dictionary<string, FuncionesForaneas>();
        ClaseEquivalente = new LenguageClass("[]", Props, Metodos);
    }
    public int Arity(){

        return 101;
    }
    public ValueWrapper Argument(List<ValueWrapper> args, CompiladorVisitor visitor){
        var NuevaInstancia = new Instancia(ClaseEquivalente);
        for (int i = 0; i < args.Count; i++)
        {
            var nombre = i.ToString();
            var valor = args[i];
            NuevaInstancia.SetCampo(nombre, valor);
        }


        return new InstanciaValue(NuevaInstancia);
    }


}*/