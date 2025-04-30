
/*using analyzer;
public class FuncionesForaneas : Argumentos {
    private Entornos close;
    private AnalizadorParser.FuncionesContext contexto;

    public FuncionesForaneas(Entornos close, AnalizadorParser.FuncionesContext contexto)
     {
        this.close = close;
        this.contexto = contexto;
    }
    public int Arity() {
        if (contexto.@params() == null) return 0;

        return contexto.@params().ID().Length;
    }

    public ValueWrapper Argument(List<ValueWrapper> args, CompiladorVisitor visitor) {
        var NuevoEntorno = new Entornos(close);
        var EntornoPrevio = visitor.Entornovariables;
        visitor.Entornovariables = NuevoEntorno;

        if (contexto.@params() != null) {
            var parametros = contexto.@params().ID();
            var tipos = contexto.@params().tipo();
            
            if (args.Count != parametros.Length) {
                throw new ArgumentException("Número incorrecto de argumentos");
            }

            for (int i = 0; i < parametros.Length; i++) {
                string nombreParametro = parametros[i].GetText();
                string tipoEsperado = tipos[i].GetText();
                ValueWrapper argumento = args[i];
                /*tipoEsperado = ImplicitaTipo(argumento);
                if (tipoEsperado !== null) {
                    throw new ArgumentException($"Tipo incorrecto para parámetro '{nombreParametro}'. Se esperaba {tipoEsperado} pero se recibió {argumento.GetType().Name}");
                }
                */
                /*NuevoEntorno.DeclareVariable(nombreParametro, argumento, null);
            }
        }

        try {
            foreach (var instruccion in contexto.dcl()) {
                visitor.Visit(instruccion);
            }
        } catch (ReturnException e) {
            visitor.Entornovariables = EntornoPrevio;
            return e.Value;
        }
        visitor.Entornovariables = EntornoPrevio;
        return visitor.defaultVoid;
    }

    /*private bool ValidarTipo(string tipoVariable, ValueWrapper valor) {
        return tipoVariable switch {
            "int" => valor is IntValue,
            "float64" => valor is FloatValue,
            "string" => valor is StringValue,
            "bool" => valor is BoolValue,
            "rune" => valor is CharValue,
            _ => false
        };
    }   */
        /*private ValueWrapper ImplicitaTipo(object valor)
    {
        if (valor is IntValue) return new StringValue("int");
        if (valor is FloatValue || valor is double) return new StringValue("float64");
        if (valor is StringValue) return new StringValue("string");
        if (valor is BoolValue) return new StringValue("bool");
      if (valor is CharValue) return new StringValue("char");
        return null; // Si no se puede determinar el tipo
    }


    /*public ValueWrapper Argument(List<ValueWrapper> args, CompiladorVisitor visitor) {
        //if (contexto.@params() == null) return defaultVoid;
        var NuevoEntorno = new Entornos(close);
        var EntornoPrevio  = visitor.Entornovariables;
        visitor.Entornovariables = NuevoEntorno;

        if (contexto.@params() != null) {
            for (int i = 0; i < contexto.@params().ID().Length; i++) {
                NuevoEntorno.DeclareVariable(contexto.@params().ID(i).GetText(), args[i], null);
            }
        }

        try {
            foreach (var instruccion in contexto.dcl()) {
                visitor.Visit(instruccion);
            }
        } catch (ReturnException e) {
            visitor.Entornovariables = EntornoPrevio;
            return e.Value;
        }
        visitor.Entornovariables = EntornoPrevio;
        return visitor.defaultVoid;
    }*/
    /*public FuncionesForaneas Bind(Instancia instancia) {
        var nuevoEntorno = new Entornos(close);
        nuevoEntorno.DeclareVariable("this", new InstanciaValue(instancia), null);
        return new FuncionesForaneas(nuevoEntorno, contexto);
    }
}
*/