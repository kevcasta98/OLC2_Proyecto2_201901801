//using analyzer;

using Antlr4.Runtime.Misc;
using analyzer;

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
        foreach (var expr in context.expr())
        {
            Visit(expr);
        }
        codigo.PopStack(Register.X0); // Sale el valor a imprimir
        codigo.PrintInteger(Register.X0);
        return null;
    }

    // VisitIdentifier
    public override object VisitIdentifier(AnalizadorParser.IdentifierContext context)
    {
    
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
        var valor = context.INT().GetText(); // Adjust this based on the actual grammar definition
        codigo.Comment("Constante: " + valor);
        codigo.Mov(Register.X0, int.Parse(valor));
        codigo.PushStack(Register.X0);
        return null;
    }

    // VisitDouble
    public override object VisitExpDouble(AnalizadorParser.ExpDoubleContext context)
    {
        return null;
    }

    // VisitString
    public override object VisitExpString(AnalizadorParser.ExpStringContext context)
    {
       
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
    
        return null;
    }

    // VisitAddSub
    public override object VisitAddSub(AnalizadorParser.AddSubContext context)
    {
        //5+2
        var operador = context.op.Text;
        var izquierda = Visit(context.expr(0)); // visit 1; Pila[5]
        var derecha = Visit(context.expr(1));  // visit 2; Pila[2,5]

        codigo.PopStack(Register.X1);//Sale el 2
        codigo.PopStack(Register.X0); //Sale el 5
        if(operador == "+")
        {
            codigo.Add(Register.X0, Register.X0, Register.X1);
        }
        else if(operador == "-")
        {
            codigo.Sub(Register.X0, Register.X0, Register.X1);
        }
        codigo.PushStack(Register.X0);
       
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