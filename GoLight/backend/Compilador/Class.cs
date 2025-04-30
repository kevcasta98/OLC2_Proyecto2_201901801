/*using analyzer;

public class LenguageClass:Argumentos{
    public string nombre { get; set; }
    public Dictionary<string,AnalizadorParser.VarDclContext> Props { get; set; }
    public Dictionary<string,FuncionesForaneas> Metodos { get; set; }

    public LenguageClass(string nombren ,
    Dictionary<string,AnalizadorParser.VarDclContext> props,
    Dictionary<string,FuncionesForaneas> metodos){
        nombre = nombren;
        Props = props;
        Metodos = metodos;
        
    }
    public FuncionesForaneas GetMethod(string name){
        if(Metodos.ContainsKey(name)){
            return Metodos[name];
        }
        return null;
    }
    public int Arity(){
        var constructor = GetMethod("constructor");
        if(constructor != null){
            return constructor.Arity();
        }
        return 0;
    }
    public ValueWrapper Argument(List<ValueWrapper> args, CompiladorVisitor visitor){
        var NuevaInstancia = new Instancia(this);
        foreach (var prop in Props)
        {
            var nombre = prop.Key;
            var valor = prop.Value;
            if(valor.expr() != null){
                var value = visitor.Visit(valor.expr());
                NuevaInstancia.SetCampo(nombre, value);
            }else{
                NuevaInstancia.SetCampo(nombre, new VoidValue());
            }
            NuevaInstancia.SetCampo(prop.Key, prop.Value.Accept(visitor));
        }
        var constructor = GetMethod("constructor");
        if(constructor != null){
            constructor.Bind(NuevaInstancia).Argument(args, visitor);
            
        }
        return new InstanciaValue(NuevaInstancia);
    }
    
}*/