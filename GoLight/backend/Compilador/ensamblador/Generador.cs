using System.Text;

public class Generador{
    private readonly List<string> instrucciones = new List<string>();
    private readonly StandardLibrary EstandarLib = new StandardLibrary();

    public void Add(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"ADD {rd}, {registro1}, {registro2}");
    }
    public void Sub(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"SUB {rd}, {registro1}, {registro2}");
    }
    public void Mul(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"MUL {rd}, {registro1}, {registro2}");
    }
    public void Div(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"DIV {rd}, {registro1}, {registro2}");
    }
    
    public void Addi(string rd, string registro1, int valor)
    {
        instrucciones.Add($"ADDI {rd}, {registro1}, #{valor}");
    }
    public void Str(string rd, string registro1, int valor = 0)
    {
        instrucciones.Add($"STR {rd}, [{registro1}, #{valor}]");
    }

    public void Ldr(string rd, string registro1, int valor = 0)
    {
        instrucciones.Add($"LDR {rd}, [{registro1}, #{valor}]");
    }

    public void Mov(string rd, int valor)
    {
        instrucciones.Add($"MOV {rd}, #{valor}");
    }

    public void PushStack(string registro)
    {
        instrucciones.Add($"STR {registro}, [SP, #-8]!");
    }
    public void PopStack(string registro)
    {
        instrucciones.Add($"LDR {registro}, [SP], #8");
    }
    public void CallSVC()
    {
        instrucciones.Add($"SVC #0");
    }
    public void FinalizarPrograma()
    {
        Mov(Register.X0, 0);
        Mov(Register.X8, 93);
        CallSVC();
    }
    //Damian menciona que debemos hacer una para comentarios y tener mas claro el codigo
    public void Comment(string comentario)
    {
        instrucciones.Add($"// {comentario}");
    }
    public void PrintInteger(string registro)
    {
        EstandarLib.Use("print_integer");
        instrucciones.Add($"MOV X0, {registro}");
        instrucciones.Add($"BL print_integer");
    }

    public override string ToString()
    {
        var sb = new StringBuilder();
        sb.AppendLine(".text");
        sb.AppendLine(".global _start");
        sb.AppendLine("_start:");
        FinalizarPrograma();
        foreach (var instruccion in instrucciones)
        {
            sb.AppendLine(instruccion);
        }
        sb.AppendLine(EstandarLib.GetFunctionDefinitions());
        return sb.ToString();
    } 


}