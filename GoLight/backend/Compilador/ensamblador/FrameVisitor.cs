using analyzer;
using Antlr4.Runtime.Misc;

public class FrameElement 
{
    public string Name {get; set;}

    public int Offset {get; set;}

    public FrameElement(string name, int offset)
    {
        Name = name;
        Offset = offset;
    }
}

public class FrameVisitor : AnalizadorBaseVisitor<Object?>
{
    public List<FrameElement> Frame;

    public int LocalOffset;

    public int BaseOffset;

    public FrameVisitor(int baseOffset)
    {
        Frame = new List<FrameElement>();
        LocalOffset = 0;
        BaseOffset = baseOffset;
    }


    public override Object? VisitVarDcl(AnalizadorParser.VarDclContext context)
    {
        string name = context.ID().GetText();

        Frame.Add(new FrameElement(name, BaseOffset + LocalOffset));
        LocalOffset += 1;

        return null;
    }


    public override Object VisitBlockStmt([NotNull] AnalizadorParser.BlockStmtContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);           
        }

        return null;
    }


    public override Object VisitIfStmt(AnalizadorParser.IfStmtContext context)
    {
        Visit(context.block(0));
        if (context.block().Length > 1) Visit(context.block(1));

        return null;
    }


    public override Object VisitWhileStmt(AnalizadorParser.WhileStmtContext context)
    {
        Visit(context.block());
        return null;
    }

    public override Object VisitForStmt(AnalizadorParser.ForStmtContext context)
    {
        if (context.forID().varDcl() != null)
        {
            Visit(context.forID().varDcl());
        }

        Visit(context.block());

        return null;
    }
}