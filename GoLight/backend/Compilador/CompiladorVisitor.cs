//using analyzer;
//Me quede en el minuto 47
using Antlr4.Runtime.Misc;
using analyzer;
//Damian puso ? luego de cada objeto, lo dejare pendiente
public class CompiladorVisitor : AnalizadorBaseVisitor<object?>
{

    public Generador codigo = new Generador();
    private string? EntornoExprType; // para saber el tipo de expresion actual del entorno

    private String? EtiquetaContinue = null;// Etiqueta para el continue

    private String? EtiquetaBreak = null;// Etiqueta para el break

    private String? EtiquetaReturn = null;// Etiqueta para el return

    public CompiladorVisitor()
    {
       EntornoExprType = null;
    }
    // VisitProgram
    public override object VisitProgram(AnalizadorParser.ProgramContext context)
    {
        foreach(var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return null;
    }

    public override object VisitBlock([NotNull] AnalizadorParser.BlockContext context)
    {
        codigo.Comment("Estoy en un bloque de instrucciones");
        codigo.NewScope();
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }

        int RemoverBytes = codigo.EndScope();
        if (RemoverBytes > 0)
        {
            codigo.Comment("Removiendo " + RemoverBytes + " bytes de la pila");
            codigo.Mov(Register.X0, RemoverBytes);
            codigo.Add(Register.SP, Register.SP, Register.X0);
        }
       
        return null;
    }

    public override object VisitFuncDeclStmt(AnalizadorParser.FuncDeclStmtContext context)
    {
        /*int baseOffset = 2;
        int paramsOffset = 0;

        if(context.@parametros() != null)
        {
            paramsOffset = context.@parametros().param().Length;
        }

        FrameVisitor frameVisitor = new FrameVisitor(baseOffset + paramsOffset);

        
        frameVisitor.Visit(context.block());
        

        var frame = frameVisitor.Frame;
        int localOffset = frame.Count;
        int returnOffset = 1;

        int totalFrameSize = baseOffset + paramsOffset + localOffset + returnOffset;

        string funcName = context.ID().GetText();
        StackObject.StackObjectType funcType = GetType(context.ID(1).GetText());

        Console.WriteLine("Total frame: " + totalFrameSize);

        functions.Add(funcName, new FunctionMetadata
        {
                totalFrameSize = totalFrameSize,
                ReturnTypeEncoder = funcType
        });

        // el frame visitor hereda del language base visitor, este manejara un elemento del frame 
        return null;*/
        return null;
    }
    //declarar slice
    public override object VisitSliceDcl([NotNull] AnalizadorParser.SliceDclContext context)
    {
        codigo.Comment($"Declaración del Vector");

        if (context.expr() != null)
        {
            codigo.PushStack(Register.HP);

            foreach (var value in context.expr())
            {
                Visit(value);
                codigo.PopObject(Register.X0);     // Valor de la expresión
                codigo.Mov(Register.X1, 1);        // Constante 1
                codigo.Add(Register.X0, Register.X0, Register.X1); // Ajuste valor (+1)
                codigo.Str(Register.X0, Register.HP, 8);             // Guardar en memoria
                //codigo.Addi(Register.HP, Register.HP, 1);          // HP++
            }

            codigo.Str(Register.XZR, Register.HP, 8); // byte nulo al final
           // codigo.Addi(Register.HP, Register.HP, 1);
        }
        
        // Simulación de objeto tipo slice
        codigo.PushObject(codigo.SliceObject());
    

        codigo.tagObject(context.ID().GetText());
        return null;
    }
    public override object VisitSliceAsign([NotNull] AnalizadorParser.SliceAsignContext context)
    {
        
	//| ID '[' expr ']' '=' expr ';'?			# SliceAsign

        string id = context.ID().GetText();
        codigo.Comment($"Asignación al Slice: {id}");

      

        // Evaluar el valor a asignar y el índice
        Visit(context.expr(1)); // valor → X0
        Visit(context.expr(0)); // índice → X2

        codigo.PopObject(Register.X2); // índice
        codigo.PopObject(Register.X0); // valor
        //codigo.Addi(Register.X0, Register.X0, 8); // Ajuste del valor

        // Obtener la dirección base del slice
        var (offset, tipo) = codigo.GetObject(id);
        codigo.Mov(Register.X1, offset); // puntero es un int
        codigo.Add(Register.X1, Register.HP, Register.X1); // ← Aquí estás usando ADD

        // Inicializar contador
        codigo.Mov(Register.X3, 0); // contador

        // Etiquetas
        string loop = codigo.GetEtiqueta();
        string fin = codigo.GetEtiqueta();
       
        string exit = codigo.GetEtiqueta();

        codigo.SetEtiqueta(loop);
        codigo.Ldr(Register.X4, Register.X1,8);       // cargar byte actual
        
        codigo.Cmp(Register.X3, Register.X2);        // contador == índice
        codigo.Beq(fin);                             // si sí, salta a asignar

        // avanzar a siguiente posición
        codigo.Addi(Register.X3, Register.X3, 1);     // contador++
        codigo.Addi(Register.X1, Register.X1, 1);     // mover puntero
        codigo.B(loop);                               // repetir


        // Asignación
        codigo.SetEtiqueta(fin);
        codigo.Str(Register.X0, Register.X1,8);        // guardar valor en posición
        codigo.B(exit);

        codigo.SetEtiqueta(exit);
        return null;
    }
    public override object VisitAccesoSlice([NotNull] AnalizadorParser.AccesoSliceContext context)
{
    string id = context.ID().GetText();
    codigo.Comment($"Acceso al Slice: {id}");

    // Evaluar el índice
    Visit(context.expr());
    codigo.PopObject(Register.X0); // índice

    // Obtener la dirección base del slice
    var (offset, tipo) = codigo.GetObject(id);
    codigo.Mov(Register.X1, offset);                 // offset base
    codigo.Add(Register.X1, Register.HP, Register.X1); // dirección base real

    // Inicializar contador
    codigo.Mov(Register.X3, 0); // contador

    // Etiquetas
    string loop = codigo.GetEtiqueta();
    string fin = codigo.GetEtiqueta();
    string error = codigo.GetEtiqueta();
    string exit = codigo.GetEtiqueta();

    codigo.SetEtiqueta(loop);
    codigo.Ldrb(Register.X4, Register.X1);       // cargar byte actual
    codigo.Cbz(Register.X4, error);              // si byte es 0, fin del slice, error
    codigo.Cmp(Register.X3, Register.X0);        // contador == índice
    codigo.Beq(fin);                             // si sí, saltar a acceso

    // avanzar
    codigo.Addi(Register.X3, Register.X3, 1);
    codigo.Addi(Register.X1, Register.X1, 1);
    codigo.B(loop);

    // Obtener el valor
    codigo.SetEtiqueta(fin);
    codigo.Ldrb(Register.X0, Register.X1);       // cargar valor en X0
    codigo.Mov(Register.X2, 1);     // guardar puntero en X1
    codigo.Sub(Register.X0, Register.X0, Register.X2);     // ajuste (-1) si al guardar se hizo +1
    codigo.PushStack(Register.X0);       // devolver valor a la pila como objeto tipo int
    codigo.B(exit);

    // Error
    codigo.SetEtiqueta(error);
    codigo.Comment("Error: índice fuera de rango");

    codigo.SetEtiqueta(exit);
    return null;
}


    public override object VisitFuncCallStmt([NotNull] AnalizadorParser.FuncCallStmtContext context)
    {
        

        return null;
    }

    public override object VisitFuncCallExpr([NotNull] AnalizadorParser.FuncCallExprContext context)
    {
       
        return null;
    }

    public override object VisitReturnStmt([NotNull] AnalizadorParser.ReturnStmtContext context)
    {
        
        return null;
    }

    public override object VisitRelational([NotNull] AnalizadorParser.RelationalContext context)
    {
        codigo.Comment("Estoy en Relacional");
        var operador = context.op.Text;

        // Visita ambas expresiones
        Visit(context.expr(0)); // izquierda
        Visit(context.expr(1)); // derecha

        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var der = codigo.PopObject(isDerFloat ? Register.D1 : Register.X1); // Derecha en D1 o X1
        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var izq = codigo.PopObject(isIzqFloat ? Register.D0 : Register.X0); // Izquierda en D0 o X0

        var trueLabel = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();

        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) codigo.Scvtf(Register.D0, Register.X0); // Izq a float
            if (!isDerFloat) codigo.Scvtf(Register.D1, Register.X1); // Der a float

            // Comparación flotante
            codigo.Fcmp(Register.D0, Register.D1);

            switch (operador)
            {
                case "<":
                    codigo.Blt(trueLabel);
                    break;
                case ">":
                    codigo.Bgt(trueLabel);
                    break;
                case "<=":
                    codigo.Ble(trueLabel);
                    break;
                case ">=":
                    codigo.Bge(trueLabel);
                    break;
                
            }
        }
        else
        {
            // Comparación entera
            codigo.Cmp(Register.X0, Register.X1); // izq vs der

            switch (operador)
            {
                case "<":
                    codigo.Blt(trueLabel);
                    break;
                case ">":
                    codigo.Bgt(trueLabel);
                    break;
                case "<=":
                    codigo.Ble(trueLabel);
                    break;
                case ">=":
                    codigo.Bge(trueLabel);
                    break;
                
            }
        }

        // Si no se cumple, falso
        codigo.Mov(Register.X0, 0);
        codigo.PushStack(Register.X0);
        codigo.B(endLabel);

        // Si se cumple, verdadero
        codigo.SetEtiqueta(trueLabel);
        codigo.Mov(Register.X0, 1);
        codigo.PushStack(Register.X0);

        // Final
        codigo.SetEtiqueta(endLabel);
        codigo.PushObject(codigo.BooleanObject());

        return null;
    }
    public override object VisitIgualDesigual([NotNull] AnalizadorParser.IgualDesigualContext context)
    {
        var operador = context.op.Text;

        // Visita ambas expresiones
        Visit(context.expr(0)); // izquierda
        Visit(context.expr(1)); // derecha

        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var der = codigo.PopObject(isDerFloat ? Register.D1 : Register.X1); // Derecha en D1 o X1
        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var izq = codigo.PopObject(isIzqFloat ? Register.D0 : Register.X0); // Izquierda en D0 o X0

        var trueLabel = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();

        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) codigo.Scvtf(Register.D0, Register.X0); // Izq a float
            if (!isDerFloat) codigo.Scvtf(Register.D1, Register.X1); // Der a float

            // Comparación flotante
            codigo.Fcmp(Register.D0, Register.D1);

            switch (operador)
            {
                case "==":
                    codigo.Beq(trueLabel);
                    break;
                case "!=":
                    codigo.Bne(trueLabel);
                    break;              
            }
        }
        else
        {
            // Comparación entera
            codigo.Cmp(Register.X0, Register.X1); // izq vs der

            switch (operador)
            {
                case "==":
                    codigo.Beq(trueLabel);
                    break;
                case "!=":
                    codigo.Bne(trueLabel);
                    break;    
            }
        }

        // Si no se cumple, falso
        codigo.Mov(Register.X0, 0);
        codigo.PushStack(Register.X0);
        codigo.B(endLabel);

        // Si se cumple, verdadero
        codigo.SetEtiqueta(trueLabel);
        codigo.Mov(Register.X0, 1);
        codigo.PushStack(Register.X0);
        // Final

        codigo.SetEtiqueta(endLabel);
        codigo.PushObject(codigo.BooleanObject());

        return null;
    }
    

    // VisitVarDcl
    public override object VisitVarDeclStmt(AnalizadorParser.VarDeclStmtContext context)
    {
        var varDcl = context.varDcl();
        if(varDcl.tipo() != null)
        {
            var tipo = varDcl.tipo().GetText();
            var id = varDcl.ID().GetText();
            codigo.Comment("Declarando variable: " + id + " de tipo: " + tipo);
            //Visit(varDcl.expr());
            if(varDcl.expr() != null)
            {
                Visit(varDcl.expr());
                codigo.tagObject(id);
                
            }
          
            
            //codigo.DeclararVariable(tipo, id);
            //codigo.PushStack(ObtenerValorPorDefecto(tipo));
        }
        
        
        return null;
    }
    private object ImplicitaTipo(object valor)
    {
        
        return null; // Si no se puede determinar el tipo
    }



    private object ObtenerValorPorDefecto(string tipo)
    {
        return null;
    }

    // VisitPrintStmt
    //Hacer un use concatString en la libreria 
    public override object VisitPrintStmt(AnalizadorParser.PrintStmtContext context)
    {   
        codigo.Comment("Imprimir");
        foreach (var expr in context.expr()) // Visitar cada expresión a imprimir
        {
            Visit(expr);  
            var isFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
            var valor = codigo.PopObject(isFloat ? Register.D0 : Register.X0); // Sale el valor a imprimir

            if (valor.Type == Generador.StackObject.StackObjectType.Int)
            {
                codigo.PrintInteger(Register.X0);
            }
            else if (valor.Type == Generador.StackObject.StackObjectType.String)
            {
                codigo.PrintString(Register.X0);
            }
            else if (valor.Type == Generador.StackObject.StackObjectType.Float)
            {
                codigo.PrintDouble();
            }
            else if (valor.Type == Generador.StackObject.StackObjectType.Boolean)
            {
                codigo.PrintBool(Register.X0);
            }       
        
        }
            // Salto de línea al final del print
        codigo.Comment("Salto de línea");
        codigo.Adr("x1", "newline");
        codigo.Mov("x2", 1);
        codigo.Mov("x0", 1);
        codigo.Mov("w8", 64);
        codigo.CallSVC();
            
        return null;
    }

    // VisitIdentifier
    public override object VisitIdentifier(AnalizadorParser.IdentifierContext context)
    {   
        var id = context.ID().GetText();
        var (puntero, varObjeto) = codigo.GetObject(id);   

        codigo.Mov(Register.X0, puntero); 
        codigo.Add(Register.X0, Register.SP, Register.X0);

        codigo.Comment("Estoy en un ID: " + id + " puntero: " + puntero);
        codigo.Ldr(Register.X0, Register.X0);
        codigo.PushStack(Register.X0);

        var nweValor = codigo.ClonarObject(varObjeto);
        nweValor.identificador = null;
        codigo.PushObject(nweValor);

        return null;
    }

    // VisitParens

    public override object VisitParens(AnalizadorParser.ParensContext context)
    {
        Visit(context.expr());
        return null;
    }
    public override object VisitCorchetes(AnalizadorParser.CorchetesContext context)
    {
        Visit(context.expr());
        return null;
    }

    // VisitNegate
    public override object VisitNegate(AnalizadorParser.NegateContext context)
    {
        codigo.Comment("Negación Unaria -");
    
    // Evaluar la expresión, revisar mas tarde

    
    
        return null;
    }
    public override object VisitOr([NotNull] AnalizadorParser.OrContext context)
    {
        codigo.Comment("Estoy en Or");
        Visit(context.expr(0));
        codigo.PopObject(Register.X0);
        var isOr = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();

        codigo.Cmp(Register.X0, "#0"); // Primero debo comparar el primer valor
        codigo.Bne(isOr);

        Visit(context.expr(1));
        codigo.PopObject(Register.X0);
        codigo.Cmp(Register.X0, "#0");//Ahora comparo el 2do
        codigo.Bne(isOr);

        codigo.Mov(Register.X0, 0);//Aqui pasa la magia 
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.BooleanObject());//Guardo en mi pila simulada
        codigo.B(endLabel);

        codigo.SetEtiqueta(isOr);
        codigo.Mov(Register.X0, 1);
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.BooleanObject());

        codigo.SetEtiqueta(endLabel);
        return null;
    }
    public override object VisitAnd([NotNull] AnalizadorParser.AndContext context)
    {
        codigo.Comment("Estoy en And");
            // Evaluar primera expresión
            // Evaluar expr1
        Visit(context.expr(0));
        codigo.PopObject(Register.X0); // X0 = resultado expr1

        var falseLabel = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();

        // Si expr1 == 0, salto a falso
        codigo.Cmp(Register.X0, "#0");
        codigo.Beq(falseLabel); // Cortocircuito

        // Evaluar expr2 solo si expr1 fue verdadera
        Visit(context.expr(1));
        codigo.PopObject(Register.X0); // X0 = resultado expr2

        // Si expr2 == 0, también es falso
        codigo.Cmp(Register.X0, "#0");
        codigo.Beq(falseLabel);

        // Ambas fueron verdaderas
        codigo.Mov(Register.X0, 1);
        codigo.B(endLabel);

        // Al menos una fue falsa
        codigo.SetEtiqueta(falseLabel);
        codigo.Mov(Register.X0, 0);

        // Fin
        codigo.SetEtiqueta(endLabel);
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.BooleanObject());
        return null;
    }

    // VisitNumber
    public override object VisitExpInteger(AnalizadorParser.ExpIntegerContext context)
    {
        codigo.Comment("Estoy en ExpInteger");
        var valor = context.INT().GetText(); // Adjust this based on the actual grammar definition
        codigo.Comment("Constante: " + valor);
        
        var integerValue = codigo.IntObject();
        codigo.PushConstantes(integerValue,int.Parse(valor));
        return null;
    }

    // VisitDouble
    public override object VisitExpDouble(AnalizadorParser.ExpDoubleContext context)
    {
        var valor = context.DECIMAL().GetText();
        codigo.Comment("Estoy en Decimal "+ valor);
        var floatValue = codigo.FloatObject();
        codigo.PushConstantes(floatValue, double.Parse(valor));
        return null;
    }

    // VisitString
    public override object VisitExpString(AnalizadorParser.ExpStringContext context)
    {
        var valor = context.CADENA().GetText().Trim('"');
        
        codigo.Comment("Estoy en ExpString "+ valor);
        var stringValue = codigo.StringObject();

        codigo.PushConstantes(stringValue, valor);
        
        return null;
    }

    // VisitBoolean
    public override object VisitExpBoolean(AnalizadorParser.ExpBooleanContext context)
    {
        var valor = context.BOOLEANO().GetText();
        codigo.Comment("Estoy en ExpBoolean "+ valor);
        var boolObj = codigo.BooleanObject();
        codigo.PushConstantes(boolObj, valor== "true"? true : false);
        return null;
    }
    public override object VisitExpChar(AnalizadorParser.ExpCharContext context)
    {
        var valor = context.CARACTER().GetText().Trim('\'');
        codigo.Comment("Estoy en ExpBoolean "+ valor);
        var stringValue = codigo.RuneObject();
        codigo.PushConstantes(stringValue, valor);
        return null;
        //return context.GetText().Trim('\'');
    }


    // VisitMulDiv
    public override object VisitMulDivMod(AnalizadorParser.MulDivModContext context)
    {
        //5+2
        var operador = context.op.Text;
        codigo.Comment("Estoy MulDivMod");
        codigo.Comment("izquierda: " );
        Visit(context.expr(0)); // visit 1; Pila[5]
        codigo.Comment("derecha: " );
        Visit(context.expr(1));  // visit 2; Pila[2,5]
        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var der = codigo.PopObject(isDerFloat ? Register.D0 : Register.X0);//Sale el 2
        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var izq = codigo.PopObject(isIzqFloat ? Register.D1 : Register.X1); //Sale el 5
        var tipoIzq = izq.Type;
        var tipoDer = der.Type;
        if(isDerFloat || isIzqFloat)
        {
            if(isIzqFloat) codigo.Scvtf(Register.D0, Register.X0);
            if(isDerFloat) codigo.Scvtf(Register.D1, Register.X1);
            if(operador == "*"){
                codigo.Fmul(Register.D0, Register.D0, Register.D1);
            }
            else if(operador == "/"){
                codigo.Fdiv(Register.D0, Register.D1, Register.D0);
            }
          
            codigo.PushStack(Register.D0);
            codigo.PushObject(codigo.ClonarObject(isIzqFloat ? izq : der));
            
            return null;
        }//enteros
        if(operador == "*")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Mul(Register.X0, Register.X0, Register.X1);
            }//Corregir
            
        }
        else if(operador == "/")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Sdiv(Register.X0, Register.X1, Register.X0);
            }//Aqui corregir
            
        }
        else if(operador == "%")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Mod(Register.X0, Register.X1, Register.X0);
            }
            
        }
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.ClonarObject(izq));
        
    
        return null;
    }

    // VisitAddSub
    public override object VisitAddSub(AnalizadorParser.AddSubContext context)
    {
        var operador = context.op.Text;
        codigo.Comment("Estoy en AddSub");

        // Visitar operandos
        codigo.Comment("Evaluando expresión izquierda");
        Visit(context.expr(0));
        codigo.Comment("Evaluando expresión derecha");
        Visit(context.expr(1));

        // Detectar tipos de operandos
        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var isDerString = codigo.TopStack().Type == Generador.StackObject.StackObjectType.String;
        var der = codigo.PopObject(isDerFloat ? Register.D0 : Register.X0); // Derecha

        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var isIzqString = codigo.TopStack().Type == Generador.StackObject.StackObjectType.String;
        var izq = codigo.PopObject(isIzqFloat ? Register.D1 : Register.X1); // Izquierda

        var tipoIzq = izq.Type;
        var tipoDer = der.Type;

        // Caso: operación entre flotantes o combinación entero/float
        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) codigo.Scvtf(Register.D1, Register.X1); // izq
            if (!isDerFloat) codigo.Scvtf(Register.D0, Register.X0); // der

            if (operador == "+")
                codigo.Fadd(Register.D0, Register.D1, Register.D0); // D0 = izq + der
            else if (operador == "-")
                codigo.Fsub(Register.D0, Register.D1, Register.D0); // D0 = izq - der

            codigo.PushStack(Register.D0);
            codigo.PushObject(codigo.FloatObject());
            return null;
        }

        // Caso: operación entre cadenas (solo +)
        if (isIzqString && isDerString)
        {
            if (operador == "+")
            {
                codigo.Comment("Concatenación de strings");
                codigo.PushStack(Register.X1); // izq
                codigo.PushStack(Register.X0); // der
                codigo.ConcatenarString();     // resultado en X0
                codigo.PushStack(Register.X0);
                codigo.PushObject(codigo.StringObject());
            }
            return null;
        }

        // Caso: operación entre enteros
        if (tipoIzq == Generador.StackObject.StackObjectType.Int &&
            tipoDer == Generador.StackObject.StackObjectType.Int)
        {
            if (operador == "+")
            {
                codigo.Add(Register.X0, Register.X1, Register.X0); // X0 = izq + der
            }
            else if (operador == "-")
            {
                codigo.Sub(Register.X0, Register.X1, Register.X0); // X0 = izq - der
            }

            codigo.PushStack(Register.X0);
            codigo.PushObject(codigo.ClonarObject(izq));
            return null;
        }

        // Si no se pudo procesar
        codigo.Comment("Operación no soportada entre los tipos dados.");
        return null;
    }
    /*public override object VisitAddSub(AnalizadorParser.AddSubContext context)
    {
        //5+2
        var operador = context.op.Text;
        codigo.Comment("Estoy en AddSub");
        codigo.Comment("izquierda: " );
        Visit(context.expr(0)); // visit 1; Pila[5]
        codigo.Comment("derecha: " );
        Visit(context.expr(1));  // visit 2; Pila[2,5]

        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var isDerString = codigo.TopStack().Type == Generador.StackObject.StackObjectType.String;
        var der = codigo.PopObject(isDerFloat ? Register.D0 : Register.X0);//Sale el 2


        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var isIzqString = codigo.TopStack().Type == Generador.StackObject.StackObjectType.String;
        var izq = codigo.PopObject(isIzqFloat ? Register.D1 : Register.X1); //Sale el 5

        
        
        var tipoIzq = izq.Type;
        var tipoDer = der.Type;

        if (isDerFloat || isIzqFloat)
        {
            // Si ambos ya son float, no conviertas nada
            if (!isIzqFloat)
                codigo.Scvtf(Register.D0, Register.X0); // Convertir entero izquierdo a float
            if (!isDerFloat)
                codigo.Scvtf(Register.D1, Register.X1); // Convertir entero derecho a float

            if (operador == "+")
                codigo.Fadd(Register.D0, Register.D0, Register.D1); // D0 = D0 + D1
            else if (operador == "-")
                codigo.Fsub(Register.D0, Register.D1, Register.D0); // D0 = D0 - D1

            codigo.PushStack(Register.D0);
            codigo.PushObject(codigo.FloatObject());

            return null;
        }
        //Trabajar los strings como los flotantes
        if(isDerString && isIzqString)
        {
            if(operador == "+")
            {
                codigo.Comment("String concatenation");
                //Llamamos a los operandos hacia X1 (izq) y X0 (der)
                codigo.PushStack(Register.X0); 
                //Concatenamos el string
                codigo.PushStack(Register.X1); 
                //Llamamos a la funcion de concatenar
                codigo.ConcatenarString(); 
                codigo.PushStack(Register.X0);
                codigo.PushObject(codigo.StringObject());
                return null;
            }

            
            return null;
        }


        if(operador == "+")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }//Corregir
            
        }
        else if(operador == "-")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Sub(Register.X1, Register.X0, Register.X0);
            }//Aqui corregir
            
        }
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.ClonarObject(izq));
       
        return null;

    }*/

    public override object VisitIncrementoDecremento([NotNull] AnalizadorParser.IncrementoDecrementoContext context)
    {
        codigo.Comment("Incremento/Decremento");

        var id = context.ID().GetText();
        var (puntero, varObjeto) = codigo.GetObject(id);
        codigo.Mov(Register.X0, puntero);
        codigo.Add(Register.X0, Register.SP, Register.X0); // Calcular dirección
        codigo.Ldr(Register.X0, Register.X0);              // Cargar valor actual

        var isFloat = varObjeto.Type == Generador.StackObject.StackObjectType.Float;

        if (isFloat)
        {
            // Float: convertir a float, sumar 1.0, volver a convertir a int
            codigo.Scvtf("d0", "x0");
            codigo.Fmov1("d1", 1.0);                   // d1 = 1.0
            codigo.Fadd("d0", "d0", "d1");            // d0 = d0 + d1
            codigo.Fcvtns("x0", "d0");                // x0 = (int)d0
        }
        else
        {
            // Int: suma directa
            codigo.Add("x0", "x0", "#1");
        }

        // Guardar el nuevo valor
        codigo.Mov(Register.X1, puntero);
        codigo.Add(Register.X1, Register.SP, Register.X1);
        codigo.Str("x0", "x1");

        // Apilar resultado
        codigo.PushStack("x0");
        var nuevoValor = codigo.ClonarObject(varObjeto);
        nuevoValor.identificador = null;
        codigo.PushObject(nuevoValor);

        return null;
    }

    // VisitNot
    public override object VisitNot(AnalizadorParser.NotContext context)
    {
        //Vamo a ver
        /*
            Solo mandamos un registro a la pila
            y luego lo negamos
            y lo volvemos a meter a la pila
            //Hacer con etiquetas
        
        */
        codigo.Comment("Negación Aritmética - (cambiar signo)");
    
        // Evaluar la expresión (ejemplo: -5 → primero se evalúa 5)
        Visit(context.expr());
        
        // Obtener el valor de la pila
        codigo.PopObject(Register.X0);  // X0 = valor a negar (ej: 5)
        
        // Negar el valor (X0 = -X0)
        codigo.Neg(Register.X0, Register.X0);  // Instrucción ARM para negación aritmética
        
        // Devolver el resultado
        codigo.PushStack(Register.X0);  // Push del valor negado (ej: -5)
        
        return null;
    }

    // VisitIfStmt
    public override object VisitIfStmt(AnalizadorParser.IfStmtContext context)
    {
        /*
        if (context.ELSE() != null)
        {
            // Si hay un bloque else, visitar el bloque
            Visit(context.block());
        }
        else
        {
            // Si no hay bloque else, solo visitar la expresión
            Visit(context.expr());
        }   

        */
        codigo.Comment("Estoy en If");
        Visit(context.expr());//aqui hay un booleano
        codigo.PopStack(Register.X0);
        var ifElse = context.block().Length > 1;
        if(ifElse){
            var elseLabel = codigo.GetEtiqueta();
            var endLabel = codigo.GetEtiqueta();
            codigo.Cbz(Register.X0, elseLabel);
            Visit(context.block(0));
            codigo.B(endLabel);
            codigo.SetEtiqueta(elseLabel);
            Visit(context.block(1));
            codigo.SetEtiqueta(endLabel);

        }
        else
        {
            var endLabel = codigo.GetEtiqueta();
            codigo.Cbz(Register.X0, endLabel);
            Visit(context.block(0));
            codigo.SetEtiqueta(endLabel);
        }


        return null;
    }

    public override object VisitAsignStmt(AnalizadorParser.AsignStmtContext context)
    {
        var varAsign = context.varAsign();
        string id = varAsign.ID().GetText();
        codigo.Comment("Asignando variable: " + id);
        Visit(varAsign.expr());

        var valor = codigo.PopObject(Register.X0);
        var (puntero, varObjeto) = codigo.GetObject(id);
        codigo.Mov(Register.X1, puntero);
        codigo.Add(Register.X1, Register.SP, Register.X1);
        codigo.Str(Register.X0, Register.X1);

        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.ClonarObject(varObjeto));
        return null;
    }
    //WHILE
    public override object VisitWhileStmt(AnalizadorParser.WhileStmtContext context)
    {
        //Este es el for tipo while
        codigo.Comment("Estoy en for tipo while");
    
        var condicion = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();

        var prevContinueLabel = EtiquetaContinue;
        var prevBreakLabel = EtiquetaBreak;
        EtiquetaContinue = condicion;
        EtiquetaBreak = endLabel;

        codigo.SetEtiqueta(condicion);
        Visit(context.expr());
        codigo.PopObject(Register.X0);
        codigo.Cbz(Register.X0, endLabel);
        Visit(context.block());
        codigo.B(condicion);
        codigo.SetEtiqueta(endLabel);

        codigo.Comment("End of while statement");

        EtiquetaContinue = prevContinueLabel;
        EtiquetaBreak = prevBreakLabel;      
        
        return null;

    }
    public override object VisitForStmt(AnalizadorParser.ForStmtContext context)
    {
        //Este es el for tipo for
        codigo.Comment("Estoy en el for clasico");
        var startLabel = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();
        var incrementLabel = codigo.GetEtiqueta(); 

        var prevContinueLabel = EtiquetaContinue;
        var prevBreakLabel = EtiquetaBreak;

        EtiquetaContinue = incrementLabel;
        EtiquetaBreak = endLabel;

        codigo.NewScope();

        Visit(context.forID());
        codigo.SetEtiqueta(startLabel);
        Visit(context.expr(0));
        codigo.PopObject(Register.X0);
        codigo.Cbz(Register.X0, endLabel);
        Visit(context.block());
        codigo.SetEtiqueta(incrementLabel);
        Visit(context.expr(1));
        codigo.B(startLabel);
        codigo.SetEtiqueta(endLabel);

        codigo.Comment("End of for statement");

        var bytesToRemove = codigo.EndScope();
        if(bytesToRemove > 0)
        {
            codigo.Comment("Removing " + bytesToRemove + "bytes from stack");
            codigo.Mov(Register.X0, bytesToRemove);
            codigo.Add(Register.SP, Register.SP, Register.X0 );
            codigo.Comment("stack pointer adjusted");
        }

        EtiquetaContinue = prevContinueLabel;
        EtiquetaBreak = prevBreakLabel;
        return null;

    }
    //continue
    public override object VisitContinueStmt(AnalizadorParser.ContinueStmtContext context)
    {
        codigo.Comment("Estoy en continue");
        if (EtiquetaContinue == null)
        {
            throw new Exception("Error: continue statement outside of loop");
        }
        codigo.B(EtiquetaContinue);
        return null;
    }
    //break
    public override object VisitBreakStmt(AnalizadorParser.BreakStmtContext context)
    {
        codigo.Comment("Estoy en break");
        if (EtiquetaBreak == null)
        {
            throw new Exception("Error: break statement outside of loop");
        }
        codigo.B(EtiquetaBreak);
        return null;
    }
    public override object VisitAsigAddSub(AnalizadorParser.AsigAddSubContext context){
        
        return null;
    }
}