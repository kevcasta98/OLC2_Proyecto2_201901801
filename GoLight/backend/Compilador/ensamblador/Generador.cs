using System.Collections;
using System.Text;

public class Generador{
    private readonly List<string> instrucciones = new List<string>();
    private readonly StandardLibrary EstandarLib = new StandardLibrary();
    private List<StackObject> stack = new List<StackObject>();
    private int stackDepth = 0;

    // Todo lo relacionado con el stack
    public void PushObject (StackObject stackObject)
    {
        stack.Add(stackObject);
    }

    public void PushConstantes(StackObject stackObject, object valor)
    {
        switch (stackObject.Type)
        {
            
            case StackObject.StackObjectType.Int:
                Mov(Register.X0, (int)valor);
                PushStack(Register.X0);
                break;
            case StackObject.StackObjectType.Float:
                
                break;
            case StackObject.StackObjectType.String:
                List<byte> Cadenas = Utils.StringToBytes((string)valor);
                PushStack(Register.HP);
                for(int i = 0; i < Cadenas.Count; i++)
                {
                    var charCode = Cadenas[i];
                    Comment($"Guardando el caracter {charCode} - ({(char)charCode}) en la posicion {Register.HP}");
                    Mov("w0", charCode);
                    Strb("w0", Register.HP);
                    Mov(Register.X0, 1);
                    Add(Register.HP, Register.HP, Register.X0);
                }
                break;
            default:
                throw new NotImplementedException();
        }
        PushObject(stackObject);

    }

    public StackObject PopObject(string registro)
    {
        var obj = stack.Last();
        stack.RemoveAt(stack.Count - 1);
        PopStack(registro);
        return obj;
    }

    public StackObject IntObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Int,
            Length = 8,
            Depth = stackDepth,
            identificador = null
        };
    }

    public StackObject FloatObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Float,
            Length = 8,
            Depth = stackDepth,
            identificador = null
        };
    }

    public StackObject StringObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.String,
            Length = 8,
            Depth = stackDepth,
            identificador = null
        };
    }

    public StackObject ClonarObject(StackObject obj){
        return new StackObject
        {
            Type = obj.Type,
            Length = obj.Length,
            Depth = obj.Depth,
            identificador = obj.identificador
        };
    }
    //==================================================================
    //Todo lo relacionado con los entornos
    public void NewScope(){
        stackDepth++;
    }
    // CUando termina el entorno debo hacer un pop
    public int EndScope(){
        int puntero = 0;
        // Elimino los objetos del stack 
        for (int i = stack.Count - 1; i >= 0; i--)
        {
            if (stack[i].Depth == stackDepth)
            {
                puntero += stack[i].Length;
                stack.RemoveAt(i);
                
            }
            else {
                break;
            }
        }
        stackDepth--;
        return puntero;
    }
    //Esto es para guardar una variable en el stack
    public void tagObject(string id){
        stack.Last().identificador = id;
    }
    //Referenciar a mi var por medio de una copia
    public (int, StackObject) GetObject(string id){
        int puntero = 0;
        for (int i = stack.Count - 1; i >= 0; i--)
        {
            if (stack[i].identificador == id)
            {
                return (puntero, stack[i]);
            }
            puntero += stack[i].Length;
        }
        throw new Exception($"No se encontro el objeto {id}");
    }


    // =================================================================
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
    public void Mod(string rd, string rn, string rm)
    {
        instrucciones.Add($"SDIV {Register.X9}, {rn}, {rm}");
        instrucciones.Add($"MLS {rd}, {Register.X9}, {rm}, {rn}");
    }
    
    public void Addi(string rd, string registro1, int valor)
    {
        instrucciones.Add($"ADDI {rd}, {registro1}, #{valor}");
    }
    public void Str(string registro1, string registro2, int valor = 0)
    {
        instrucciones.Add($"STR {registro1}, [{registro2}, #{valor}]");
    }

    public void Strb(string registro1, string registro2)
    {
        instrucciones.Add($"STRB {registro1}, [{registro2}]");
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

    public void PrintString(string registro)
    {
        EstandarLib.Use("print_string");
        instrucciones.Add($"MOV X0, {registro}");
        instrucciones.Add($"BL print_string");
    }

    public void PrintDouble(string registro)
    {
        EstandarLib.Use("print_double");
        instrucciones.Add($"MOV X0, {registro}");
        instrucciones.Add($"BL print_double");
    }

    public override string ToString()
    {
        var sb = new StringBuilder();
        sb.AppendLine(".data");
        sb.AppendLine("heap: .space 4096");//4096 bytes


        sb.AppendLine(".text");
        sb.AppendLine(".global _start");
        sb.AppendLine("_start:");
        sb.AppendLine("adr x10, heap");//address y crece para arriba y no lo decrementaremos 

        
         FinalizarPrograma();
        foreach (var instruccion in instrucciones)
        {
            sb.AppendLine(instruccion);
        }
       
        sb.AppendLine(EstandarLib.GetFunctionDefinitions());
        return sb.ToString();
    } 

    public class StackObject{
        public enum StackObjectType
        {
            Int,
            Float,
            String
           
        }
        public StackObjectType Type { get; set; }
        public int Length { get; set; }
        public int Depth { get; set; }// Este es como mi padre y aumentare a 1 por cada entorno 
        public string? identificador { get; set; }
    }


}