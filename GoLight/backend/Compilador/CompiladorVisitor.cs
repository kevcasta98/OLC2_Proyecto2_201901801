//using analyzer;
//Me quede en el minuto 47
using Antlr4.Runtime.Misc;
using analyzer;
//Damian puso ? luego de cada objeto, lo dejare pendiente
public class CompiladorVisitor : AnalizadorBaseVisitor<object?>
{

    public Generador codigo = new Generador();

    public CompiladorVisitor()
    {
       
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
        Visit(context.expr(0)); // visit 1; Pila[5]
        Visit(context.expr(1));  // visit 2; Pila[2,5]

        var isDerFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var der = codigo.PopObject(isDerFloat ? Register.D0 : Register.X0);//Sale el 2
        var isIzqFloat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
        var izq = codigo.PopObject(isIzqFloat ? Register.D1 : Register.X1); //Sale el 5
        var tipoIzq = izq.Type;
        //usar izq.Type 
        var tipoDer = der.Type;

        if(isDerFloat || isIzqFloat)
        {
            if(isIzqFloat) codigo.Scvtf(Register.D0, Register.X0);
            if(isDerFloat) codigo.Scvtf(Register.D1, Register.X1);
            

            codigo.PushStack(Register.D0);
            codigo.PushObject(codigo.ClonarObject(isIzqFloat ? izq : der));
            
            return null;
        }
        codigo.Cmp(Register.X1, Register.X0);//x1 = var de la izquierda
        var trueLabel = codigo.GetEtiqueta();
        var endLabel = codigo.GetEtiqueta();
        switch(operador)
        {
            case "<":
                codigo.Blt(trueLabel);
                break;
            case ">":
                codigo.Blt(trueLabel);
                break;
            case "<=":
                codigo.Blt(trueLabel);
                break;
            case ">=":
                codigo.Blt(trueLabel);
                break;
            case "==":
                //codigo.Cmp(Register.X1, Register.X0);
                codigo.Blt(trueLabel);
                break;
            case "!=":
                codigo.Blt(trueLabel);
                break;
        }

        codigo.Mov(Register.X0, 0);
        codigo.PushStack(Register.X0);
        codigo.B(endLabel);
        codigo.SetEtiqueta(trueLabel);
        codigo.Mov(Register.X0, 1);
        codigo.PushStack(Register.X0);
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
        
        }
            var isFLoat = codigo.TopStack().Type == Generador.StackObject.StackObjectType.Float;
            var valor = codigo.PopObject(isFLoat ? Register.D0 : Register.X0); // Sale el valor a imprimir

            if(valor.Type == Generador.StackObject.StackObjectType.Int)
            {
                codigo.PrintInteger(Register.X0);

            }
            else if(valor.Type == Generador.StackObject.StackObjectType.String)
            {
                codigo.PrintString(Register.X0);
                
            }
            else if(valor.Type == Generador.StackObject.StackObjectType.Float)
            {
                codigo.PrintDouble();
            }
            else if(valor.Type == Generador.StackObject.StackObjectType.Boolean)
            {
                codigo.PrintBool(Register.X0);
            }

            codigo.Add(Register.SP, Register.SP, "#8");
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
        return null;
    }
    public override object VisitCorchetes(AnalizadorParser.CorchetesContext context)
    {
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
        codigo.Comment("Estoy en AddSub");
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

        if(isDerFloat || isIzqFloat)
        {
            if(isIzqFloat) codigo.Scvtf(Register.D0, Register.X0);
            if(isDerFloat) codigo.Scvtf(Register.D1, Register.X1);
            if(operador == "+"){
                codigo.Fadd(Register.D0, Register.D0, Register.D1);
            }
            else if(operador == "-"){
                codigo.Fsub(Register.D0, Register.D1, Register.D0);
            }
            codigo.PushStack(Register.D0);
            codigo.PushObject(codigo.ClonarObject(isIzqFloat ? izq : der));
            
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

    }

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
       
        
        return null;

    }
    public override object VisitAsigAddSub(AnalizadorParser.AsigAddSubContext context){
        
        return null;
    }
}