using analyzer;
/*
public class LanguageMatrices : Argumentos
{
    public string Nombre { get; set; }
    private List<List<ValueWrapper>> Matriz;
    private LenguageClass ClaseEquivalente;

    public LanguageMatrices()
    {
        Matriz = new List<List<ValueWrapper>>();
    }

    public int Arity()
    {
        return 101;
    }

    public ValueWrapper Argument(List<ValueWrapper> args, CompiladorVisitor visitor)
    {
        Matriz.Clear();
        var NuevaInstancia = new Instancia(ClaseEquivalente);

        foreach (var arg in args)
        {
            if (arg is InstanciaValue instanceValue && instanceValue.instance is List<ValueWrapper> fila)
            {
                Matriz.Add(fila);
            }
            else
            {
                throw new Exception("Todos los elementos de una matriz deben ser listas.");
            }
        }

        return new InstanciaValue(new InstanciaMatriz(Matriz));
    }

    public override string ToString()
    {
        return "[\n" + string.Join("\n", Matriz.Select(fila => "[ " + string.Join(", ", fila) + " ]")) + "\n]";
    }
}

// Clase que representa una matriz como instancia
public class InstanciaMatriz
{
    public List<List<ValueWrapper>> Matriz { get; }

    public InstanciaMatriz(List<List<ValueWrapper>> matriz)
    {
        Matriz = matriz;
    }
}
*/