//using analyzer;

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
    public override object VisitPrintStmt(AnalizadorParser.PrintStmtContext context)
    {   
        codigo.Comment("Imprimir");
        foreach (var expr in context.expr()) // Visitar cada expresión a imprimir
        {
            Visit(expr);
        }
        var valor = codigo.PopObject(Register.X0); // Sale el valor a imprimir

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
            codigo.PrintDouble(Register.X0);
        }

        
        //codigo.PrintDouble(Register.X0);
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
        codigo.PushConstantes(floatValue, float.Parse(valor));
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
        return null;
    }
    public override object VisitExpChar(AnalizadorParser.ExpCharContext context)
    {
        
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
        codigo.PopStack(Register.X1);//Sale el 2
        codigo.PopStack(Register.X0); //Sale el 5
        if(operador == "*")
        {
            codigo.Mul(Register.X0, Register.X0, Register.X1);
        }
        else if(operador == "/")
        {
            codigo.Div(Register.X0, Register.X0, Register.X1);
        }
        else if(operador == "%")
        {
            codigo.Mod(Register.X0, Register.X0, Register.X1);
        }

        codigo.PushStack(Register.X0);
    
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
        
        var der = codigo.PopObject(Register.X1);//Sale el 2
        var izq = codigo.PopObject(Register.X0); //Sale el 5
        
        var tipoIzq = izq.Type;
        //usar izq.Type 
        var tipoDer = der.Type;
        if(operador == "+")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }else if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Float)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }
            else if(tipoIzq == Generador.StackObject.StackObjectType.Float && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }
            else if(tipoIzq == Generador.StackObject.StackObjectType.Float && tipoDer == Generador.StackObject.StackObjectType.Float)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }
            else if(tipoIzq == Generador.StackObject.StackObjectType.String && tipoDer == Generador.StackObject.StackObjectType.String)
            {
                codigo.Add(Register.X0, Register.X0, Register.X1);
            }
        }
        else if(operador == "-")
        {
            if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Sub(Register.X0, Register.X0, Register.X1);
            }else if(tipoIzq == Generador.StackObject.StackObjectType.Int && tipoDer == Generador.StackObject.StackObjectType.Float)
            {
                codigo.Sub(Register.X0, Register.X0, Register.X1);
            }
            else if(tipoIzq == Generador.StackObject.StackObjectType.Float && tipoDer == Generador.StackObject.StackObjectType.Int)
            {
                codigo.Sub(Register.X0, Register.X0, Register.X1);
            }
            else if(tipoIzq == Generador.StackObject.StackObjectType.Float && tipoDer == Generador.StackObject.StackObjectType.Float)
            {
                codigo.Sub(Register.X0, Register.X0, Register.X1);
            }
        }
        codigo.PushStack(Register.X0);
        codigo.PushObject(codigo.ClonarObject(izq));
       
        return null;

    }

 

    // VisitNot
    public override object VisitNot(AnalizadorParser.NotContext context)
    {
        return null;
    }

    // VisitIfStmt
    public override object VisitIfStmt(AnalizadorParser.IfStmtContext context)
    {
        

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