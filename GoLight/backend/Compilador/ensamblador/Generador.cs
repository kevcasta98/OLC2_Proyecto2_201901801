using System.Collections;
using System.Text;
using System.Globalization;

public class Generador{
    private readonly List<string> instrucciones = new List<string>();
    private readonly StandardLibrary EstandarLib = new StandardLibrary();
    private List<StackObject> stack = new List<StackObject>();
    private int stackDepth = 0;
    private int ContadorEtiquetas = 0;

    public string GetEtiqueta()
    {
        return $"L{ContadorEtiquetas++}";
    }
    public void SetEtiqueta(string etiqueta)
    {
        instrucciones.Add($"{etiqueta}:");
    }

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
                long valorFloat = BitConverter.DoubleToInt64Bits((double)valor);
                ushort[] partes = new ushort[4]; // aquí usamos ushort
                for (int i = 0; i < 4; i++)
                {
                    partes[i] = (ushort)((valorFloat >> (i * 16)) & 0xFFFF); // conversión explícita a ushort
                }
                instrucciones.Add($"MOVZ x0, #{partes[0]}, LSL #0");

                for (int i = 1; i < 4; i++)
                {
                    instrucciones.Add($"MOVK x0, #{partes[i]}, LSL #{i * 16}");
                }
                PushStack(Register.X0);
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
            case StackObject.StackObjectType.caracter:
                Mov(Register.X0, (char)valor);
                PushStack(Register.X0);
                break;
            case StackObject.StackObjectType.Boolean:
                Mov(Register.X0, (bool)valor ? 1 : 0);
                PushStack(Register.X0);
                break;
            default:
                throw new NotImplementedException();
        }
        PushObject(stackObject);

    }
    // Todo lo relacionado con la pila
    public StackObject TopStack(){
        return stack.Last();
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
    public StackObject BooleanObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Boolean,
            Length = 8,
            Depth = stackDepth,
            identificador = null
        };
    }
    public StackObject RuneObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.String,
            Length = 8,
            Depth = stackDepth,
            identificador = null
        };
    }
        public StackObject SliceObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Slice,
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
    public void Ldrb(string rd, string registro1)
    {
        instrucciones.Add($"LDRB {rd}, [{registro1}]");
    }
    public void Fcmp(string registro1, string registro2)
    {
        instrucciones.Add($"FCMP {registro1}, {registro2}");
    }
    public void Ble(string etiqueta)
    {
        instrucciones.Add($"BLE {etiqueta}");
    }
    public void Bge(string etiqueta)
    {
        instrucciones.Add($"BGE {etiqueta}");
    }
    public void Mul(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"MUL {rd}, {registro1}, {registro2}");
    }
    public void Div(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"DIV {rd}, {registro1}, {registro2}");
    }
    public void Cmp(string registro1, string registro2)
    {
        instrucciones.Add($"CMP {registro1}, {registro2}");
    }

    public void Cbz(string registro, string etiqueta)//Flag para ver si el valor es 0
    {
        instrucciones.Add($"CBZ {registro}, {etiqueta}");
    }
    
    public void Beq(string etiqueta)
    {
        instrucciones.Add($"BEQ {etiqueta}");
    }
    public void Bne(string etiqueta)
    {
        instrucciones.Add($"BNE {etiqueta}");
    }
    public void Bgt(string etiqueta)
    {
        instrucciones.Add($"BGT {etiqueta}");
    }
    public void Blt(string etiqueta)
    {
        instrucciones.Add($"BLT {etiqueta}");
    }

    public void Mod(string rd, string rn, string rm)
    {
        instrucciones.Add($"SDIV {Register.X9}, {rn}, {rm}");
        instrucciones.Add($"MSUB {rd}, {Register.X9}, {rm}, {rn}");
    }
    public void Sdiv(string rd, string rn, string rm)
    {
        instrucciones.Add($"SDIV {rd}, {rn}, {rm}");
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
    public void Adr(string destino, string etiqueta)
{
    instrucciones.Add($"ADR {destino}, {etiqueta}");
}
    public void MovReg(string destino, string origen)
    {
        instrucciones.Add($"MOV {destino}, {origen}");
    }

    public void PushStack(string registro)
    {
        instrucciones.Add($"STR {registro}, [SP, #-8]!");
    }

    public void Neg(string destino, string origen)
    {
        Comment("Negación unaria");
        Mov(destino, 0);
        Sub(destino, destino, origen); // destino = 0 - origen
    }
    public void Fcvtns(string rd, string registro)
    {
        instrucciones.Add($"FCVTNS {rd}, {registro}");
    }
    public void Fneg(string destino, string origen)
    {
        Comment("Negación unaria");
        Mov(destino, 0);
        Fsub(destino, destino, origen); // destino = 0 - origen
    }
    public void PopStack(string registro)
    {
        instrucciones.Add($"LDR {registro}, [SP], #8");
    }

    public void B(string etiqueta)
    {
        instrucciones.Add($"B {etiqueta}");
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
    public void Scvtf(string rd, string registro)
    {
        instrucciones.Add($"SCVTF {rd}, {registro}");
    }
    public void Fmov(string rd, string registro)
    {
        instrucciones.Add($"FMOV {rd}, {registro}");
    }
    public void Fmov1(string rd, double value)
{
    var valStr = value.ToString(System.Globalization.CultureInfo.InvariantCulture);
    instrucciones.Add($"FMOV {rd}, {valStr}");
}
    public void Fadd(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"FADD {rd}, {registro1}, {registro2}");
    }
    public void Fsub(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"FSUB {rd}, {registro1}, {registro2}");
    }
    public void Fmul(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"FMUL {rd}, {registro1}, {registro2}");
    }
    public void Fdiv(string rd, string registro1, string registro2)
    {
        instrucciones.Add($"FDIV {rd}, {registro1}, {registro2}");
    }
    public void Ret(){
        instrucciones.Add($"RET");
    }
    public void PrintDouble()
    {
        EstandarLib.Use("print_integer");
        EstandarLib.Use("print_double");
       // instrucciones.Add($"MOV X0, {registro}");
        instrucciones.Add($"BL print_double");
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
        public void PrintBool(string registro)
    {
        EstandarLib.Use("print_boolean");
        instrucciones.Add($"MOV X0, {registro}");
        instrucciones.Add($"BL print_boolean");
    }



    public void ConcatenarString()
    {
        EstandarLib.Use("concat_strings");
        instrucciones.Add($"BL concat_strings");
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
            String,
            Boolean,
            caracter,
            Slice   
        }
        public StackObjectType Type { get; set; }
        public object Value { get; set; } 
        public int Length { get; set; }
        public int Depth { get; set; }// Este es como mi padre y aumentare a 1 por cada entorno 
        public string? identificador { get; set; }
    }


}