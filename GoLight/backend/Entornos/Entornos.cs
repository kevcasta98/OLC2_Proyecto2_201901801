using analyzer;

public class Entornos {

    //private Environment? parent;
    //private Entornos? parent;

    /*public Entornos(Entornos? parent)
    {
        this.parent = parent;
    }*/
    // Lista de palabras reservadas
    private readonly HashSet<string> palabrasReservadas = new HashSet<string> {
        "var", "if", "else", "while", "for", "return", "function", "true", "false",
        "int", "float64", "string", "bool", "char", "void"
    };
    //private Errores error = new Errores();

    public Dictionary<string, Symbol> Variables = new Dictionary<string, Symbol>();
    private Dictionary<string,  (List<string> parameters, AnalizadorParser.BlockContext body)> functions = new();
    public Entornos Parent { get; set; }

    public Entornos(Entornos parent = null)
    {
        Parent = parent;
    }

    public Symbol GetVariable(string id)
    {
        if (Variables.ContainsKey(id))
        {
            return Variables[id];
        }
        else if (Parent != null)
        {
            return Parent.GetVariable(id);
        }
        else
        {
            //throw new Exception("Variable " + id + " not found");
            return null;
        }
    }

    public void SetVariable(string id, object value, SymbolType type)
    {
        if (Variables.ContainsKey(id))
        {
            Variables[id] = new Symbol(value, type);
        }
        else
        {
            Variables.Add(id, new Symbol(value, type));
        }
    }

    public void SetFunciones(string id, List<string> parametros, AnalizadorParser.BlockContext body)
    {
        if (functions.ContainsKey(id))
        {
            functions[id] = (parametros, body);
        }
        else
        {
            functions.Add(id, (parametros, body));
        }
    }
    public object GetFuncion(string id)
    {
        if (functions.ContainsKey(id))
        {
            return functions[id];
        }
        else if (Parent != null)
        {
            return Parent.GetVariable(id);
        }
        else
        {
            return null;
        }
    }
  
}
public enum SymbolType
{
    Integer,
    Double,
    String,
    Boolean ,
    Char,
    Void
}
public class Symbol
{
    public object Value { get; set; }
    public SymbolType Type { get; set; }

    public Symbol(object value, SymbolType type)
    {
        Value = value;
        Type = type;
    }
}