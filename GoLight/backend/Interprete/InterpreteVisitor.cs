//using analyzer;

using Antlr4.Runtime.Misc;
using analyzer;

public class InterpreteVisitor : AnalizadorBaseVisitor<object>
{
    public string output = "";
    private Entornos currentEnvironment = new Entornos();
    public Errores errores = new Errores();
    private Dictionary<string, (List<string> parameters, AnalizadorParser.BlockContext body)> functions = new();

    // VisitProgram
    public override object VisitProgram(AnalizadorParser.ProgramContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return null;
    }

    public override object VisitBlock([NotNull] AnalizadorParser.BlockContext context)
    {
        object ret = null;
        foreach (var dcl in context.dcl())
        {
            ret = Visit(dcl);
            if (dcl.GetType().Name == "ReturnStmtContext")
            {
                Console.WriteLine(dcl.GetType().Name);
                Console.WriteLine(ret);
                return ret;
            }
        }
        return ret;
    }

    public override object VisitFuncDeclStmt(AnalizadorParser.FuncDeclStmtContext context)
    {
        string id = context.ID().GetText();
        var parameters = context.parametros()?.param().Select(p => p.ID().GetText()).ToList() ?? new List<string>();
        var body = context.block();

        functions[id] = (parameters, body);
        return null;
    }

    public override object VisitFuncCallStmt([NotNull] AnalizadorParser.FuncCallStmtContext context)
    {
        string id = context.varCall().ID().GetText();
        var args = context.varCall().args()?.expr().Select(expr => Visit(expr)).ToList() ?? new List<object>();

        var (parameters, body) = functions[id];

        if (args.Count != parameters.Count)
        {
            throw new Exception("LA CANTIDAD DE PARAMETROS TIENE QUE SER IGUAL");
        }

        Entornos new_environment = new Entornos();
        Entornos aux_enviroment = currentEnvironment;

        currentEnvironment = new_environment;

        // a, b, c parametros
        // 10,45,30 argumentos
        /*
        func suma(x,y,z){
            print(x+y+z);
        }
        suma(1,2,3);
        */


        for (var i = 0; i < args.Count; i++)
        {
            currentEnvironment.SetVariable(parameters[i], args[i], SymbolType.Integer);
        }

        Visit(body);
        Console.WriteLine("CALL FUNCTION");

        currentEnvironment = aux_enviroment;

        return null;
    }

    public override object VisitFuncCallExpr([NotNull] AnalizadorParser.FuncCallExprContext context)
    {
        string id = context.varCall().ID().GetText();
        var args = context.varCall().args()?.expr().Select(expr => Visit(expr)).ToList() ?? new List<object>();

        var (parameters, body) = functions[id];

        if (args.Count != parameters.Count)
        {
            throw new Exception("LA CANTIDAD DE PARAMETROS TIENE QUE SER IGUAL");
        }

        Entornos new_environment = new Entornos();
        Entornos aux_enviroment = currentEnvironment;

        currentEnvironment = new_environment;

        for (var i = 0; i < args.Count; i++)
        {
            currentEnvironment.SetVariable(parameters[i], args[i], SymbolType.Integer);
        }

        var ret = Visit(body);
        Console.WriteLine("CALL EXPRESION");
        Console.WriteLine(ret);
        //currentEnvironment = aux_enviroment;
        /*
        func suma(a:Integer, b:Integer):Integer{
        var c:Integer = a+b;
        if (c>3){
        return 5;
        }
        return a+b;
        }

        var x:Integer = suma(2,2);
        print(x);
        */
        return ret;
    }

    public override object VisitReturnStmt([NotNull] AnalizadorParser.ReturnStmtContext context)
    {
        Console.WriteLine("RETURN");
        var ret = Visit(context.expr());
        Console.WriteLine(ret);
        return ret;
    }

    // VisitVarDcl
    public override object VisitVarDeclStmt(AnalizadorParser.VarDeclStmtContext context)
    {
        var varDecl = context.varDcl();

        if (varDecl.tipo() != null)
        {
            string id = varDecl.ID().GetText();
            string tipoVariable = varDecl.tipo().GetText();
            int linea = context.Start.Line;
            int columna = context.Start.Column;

            object value;

            if (varDecl.expr() != null)
            {
                value = Visit(varDecl.expr());

                // Validar si el tipo de la variable coincide con el valor asignado
                if (!ValidarTipo(tipoVariable, value))
                {
                    errores.setError("Sintáctico", $"No se puede asignar un valor de tipo {value.GetType().Name} a la variable '{id}' de tipo {tipoVariable}", linea, columna);
                    return $"Error Sintáctico, No se puede asignar un valor de tipo {value.GetType().Name} a la variable '{id}' de tipo {tipoVariable}";
                }
            }
            else
            {
                value = ObtenerValorPorDefecto(tipoVariable);
            }

            currentEnvironment.SetVariable(id, value, SymbolType.Integer);
        }
        else if (varDecl.expr() != null) // Declaración implícita
        {
            string id = varDecl.ID().GetText();
            int linea = context.Start.Line;
            int columna = context.Start.Column;
            object valor = Visit(varDecl.expr());
            object tipoInferido = ImplicitaTipo(valor);
            currentEnvironment.SetVariable(id, valor, SymbolType.Integer);
            Console.WriteLine("Nombre de la variable: " + id + " (Inferido: " + tipoInferido + ") valor: " + valor);
        }

        return null;
    }

    private object ImplicitaTipo(object valor)
    {
        if (valor is int) return "int";
        if (valor is Double || valor is double) return "float64";
        if (valor is string) return "string";
        if (valor is bool) return "bool";
        if (valor is char) return "char";
        return null; // Si no se puede determinar el tipo
    }


    private bool ValidarTipo(string tipoVariable, Object valor)
    {
        return tipoVariable switch
        {
            "int" => valor is int,
            "float64" => valor is Double,
            "string" => valor is String,
            "bool" => valor is bool,
            "rune" => valor is Char,
            _ => false
        };
    }
    private object ObtenerValorPorDefecto(string tipo)
    {
        return tipo switch
        {
            "int" => 0,
            "float64" => 0.0,
            "string" => "",
            "bool" => false,
            "rune" => '\0',
            _ => throw new Exception($"Tipo desconocido: {tipo}")
        };
    }

    // VisitPrintStmt
    public override object VisitPrintStmt(AnalizadorParser.PrintStmtContext context)
    {
        //object value = Visit(context.expr());
        //output += value + "\n";
        var valores = context.expr().Select(expr => Visit(expr)); // Lista de ValueWrapper

        foreach (var valor in valores)
        {
            output += valor; // Agrega el valor al output
            output += " "; // Agrega un espacio entre valores
        }

        output += "\n"; // Salto de línea al final
        return null;
    }

    // VisitIdentifier
    public override object VisitIdentifier(AnalizadorParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.GetVariable(id).Value;
    }

    // VisitParens

    public override object VisitParens(AnalizadorParser.ParensContext context)
    {
        return Visit(context.expr());
    }
    public override object VisitCorchetes(AnalizadorParser.CorchetesContext context)
    {
        return Visit(context.expr());
    }

    // VisitNegate
    public override object VisitNegate(AnalizadorParser.NegateContext context)
    {
        object value = Visit(context.expr());

        if (value is int intValue) return -intValue;
        if (value is double doubleValue) return -doubleValue;

        throw new Exception("Negation can only be applied to numbers.");
    }

    // VisitNumber
    public override object VisitExpInteger(AnalizadorParser.ExpIntegerContext context)
    {
        return int.Parse(context.GetText());
    }

    // VisitDouble
    public override object VisitExpDouble(AnalizadorParser.ExpDoubleContext context)
    {
        return double.Parse(context.GetText());
    }

    // VisitString
    public override object VisitExpString(AnalizadorParser.ExpStringContext context)
    {
        string cadenaConComillas = context.GetText();
        string cadenaSinComillas = cadenaConComillas.Substring(1, cadenaConComillas.Length - 2);
        if (cadenaConComillas.Contains("\\n"))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\n", "\n");
        }
        else if (cadenaConComillas.Contains("\\t"))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\t", "\t");
        }
        else if (cadenaConComillas.Contains("\\r"))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\r", "\r");
        }
        else if (cadenaConComillas.Contains("\\\""))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\\"", "\"");
        }
        else if (cadenaConComillas.Contains("\\'"))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\'", "'");
        }
        else if (cadenaConComillas.Contains("\\\\"))
        {
            cadenaSinComillas = cadenaSinComillas.Replace("\\\\", "\\");
        }

        Console.WriteLine(cadenaSinComillas);
        return cadenaSinComillas;
    }

    // VisitBoolean
    public override object VisitExpBoolean(AnalizadorParser.ExpBooleanContext context)
    {
        return bool.Parse(context.GetText());
    }
    public override object VisitExpChar(AnalizadorParser.ExpCharContext context)
    {
        string texto = context.CARACTER().GetText(); // Devuelve algo como "'a'"
        char caracter = texto[1]; // Obtiene solo el carácter dentro de las comillas
        return caracter;
        //return context.GetText().Trim('\'');
    }

    // VisitMulDiv
    public override object VisitMulDivMod(AnalizadorParser.MulDivModContext context)
    {
        string operador = context.GetChild(1).GetText();
        Console.WriteLine("Operador: " + operador);
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        int linea = context.Start.Line;
        int columna = context.Start.Column;
        

        var tipoLeft = left.GetType().Name;
        var tipoRight = right.GetType().Name;

        if (operador == "*")
        {
            Console.WriteLine(left + " * " + right);
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left * (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left * (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left * (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left * (double)right;
            }

            else
            {
                errores.setError("Semantico", "No se puede multiplicar " + tipoLeft + " con " + tipoRight, linea, columna);
                return "Error Semantico, error de tipos en la multiplicacion";
            }
        }
        else if (operador == "/")
        {
            Console.WriteLine(left + " / " + right);
            if ((right is int && (int)right == 0) || (right is double && (double)right == 0.0))
            {
                errores.setError("Semantico", "No se puede dividir entre 0", linea, columna);
                return "Error Semantico, No se puede dividir entre 0";
            }


            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left / (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left / (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left / (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left / (double)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede dividir " + tipoLeft + " con " + tipoRight, linea, columna);
                return "Error Semantico, error de tipos en la división";
            }
        }
        else if (operador == "%")
        {
            Console.WriteLine(left + " % " + right);
            if ((right is int && (int)right == 0) || (right is double && (double)right == 0.0))
            {
                errores.setError("Semantico", "No se puede calcular el modulo con divisor 0", linea, columna);
                return "Error Semantico, No se puede realizar una operación de módulo con divisor 0.";
            }
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left % (int)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede realizar el módulo entre " + tipoLeft + " con " + tipoRight, linea, columna);
                return "Error Semantico, error de tipos en el modulo";
            }
        }
        return null;
    }
    public override object VisitIgualDesigual(AnalizadorParser.IgualDesigualContext context)
    {
        //| expr op = ('==' | '!=') expr				# IgualDesigual
        string operador = context.GetChild(1).GetText();
    
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        int linea = context.Start.Line;
        int columna = context.Start.Column;
        if(operador == "=="){
            if (left.Equals(right))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(operador == "!="){
            if (!left.Equals(right))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else{
            errores.setError("Semantico", "No se puede realizar la operación de igualdad o desigualdad", linea, columna);
            return "Error Semantico, No se puede realizar la operación de igualdad o desigualdad";
        }
        
        return null;

    }

    // VisitAddSub
    public override object VisitAddSub(AnalizadorParser.AddSubContext context)
    {
        string operador = context.GetChild(1).GetText();
        Console.WriteLine("Operador: " + operador);

        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));

        int linea = context.Start.Line;
        int columna = context.Start.Column;
        Console.WriteLine("Columna: " + columna);
        if (left is null || right is null)
        {
            errores.setError("Semantico", "No se puede realizar la operación de suma o resta", linea, columna);
            return "Error Semantico, No se puede realizar la operación de suma o resta";
        }

        var tipoLeft = left.GetType().Name;
        var tipoRight = right.GetType().Name;

        if (operador == "+")
        {
            Console.WriteLine(left + " + " + right);

            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left + (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left + (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left + (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left + (double)right;
            }
            else if (tipoLeft == "string" && tipoRight == "string")
            {
                return (string)left + (string)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede sumar " + tipoLeft + " con " + tipoRight, linea, columna);
                return "Error Semantico, error de tipos en la suma";
            }
        }
        else if (operador == "-")
        {
            Console.WriteLine(left + " - " + right);

            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left - (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left - (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left - (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left - (double)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede restar " + tipoLeft + " con " + tipoRight, linea, columna);
                return "Error Semantico, error de tipos en la resta";
            }
        }


        return null;

    }

    // 	# And
    public override object VisitAnd([NotNull] AnalizadorParser.AndContext context)
    {
        //expr op = '&&' expr
        string operador = context.GetChild(1).GetText();
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        int linea = context.Start.Line; 
        int columna = context.Start.Column;
        if (operador == "&&")
        {
            Console.WriteLine(left + " && " + right);
            if (left is bool && right is bool)
            {
                return (bool)left && (bool)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede realizar la operación de and", linea, columna);
                return "Error Semantico, No se puede realizar la operación de and";
            }
        }
        else
        {
            errores.setError("Semantico", "No se puede realizar la operación de and", linea, columna);
            return "Error Semantico, No se puede realizar la operación de and";
        }
        return null;
    }
    // 	# Or
    public override object VisitOr([NotNull] AnalizadorParser.OrContext context)
    {
        //expr op = '||' expr
        string operador = context.GetChild(1).GetText();
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        int linea = context.Start.Line; 
        int columna = context.Start.Column;
        if (operador == "||")
        {
            Console.WriteLine(left + " || " + right);
            if (left is bool && right is bool)
            {
                return (bool)left || (bool)right;
            }
            else
            {
                errores.setError("Semantico", "No se puede realizar la operación de Or", linea, columna);
                return "Error Semantico, No se puede realizar la operación de Or";
            }
        }
        else
        {
            errores.setError("Semantico", "No se puede realizar la operación de Or", linea, columna);
            return "Error Semantico, No se puede realizar la operación de Or";
        }
        return null;
    }

    //Relational
    public override object VisitRelational(AnalizadorParser.RelationalContext context)
    {
        //expr op = ('<' | '<=' | '>' | '>=') expr	# Relational
        string operador = context.GetChild(1).GetText();
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        int linea = context.Start.Line;
        int columna = context.Start.Column;
        var tipoLeft = left.GetType().Name;
        var tipoRight = right.GetType().Name;
        if (operador == "<")
        {
            Console.WriteLine(left + " < " + right);
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left < (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left < (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left < (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left < (double)right;
            }
        }
        else if (operador == "<=")
        {
            Console.WriteLine(left + " <= " + right);
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left <= (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left <= (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left <= (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left <= (double)right;
            }
        }
        else if (operador == ">")
        {
            Console.WriteLine(left + " > " + right);
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left > (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left > (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left > (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left > (double)right;
            }
        }
        else if (operador == ">=")
        {
            Console.WriteLine(left + " >=" + right);
            if (tipoLeft == "Int32" && tipoRight == "Int32")
            {
                return (int)left >= (int)right;
            }
            else if (tipoLeft == "Int32" && tipoRight == "Double")
            {
                return (int)left >= (double)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Int32")
            {
                return (double)left >= (int)right;
            }
            else if (tipoLeft == "Double" && tipoRight == "Double")
            {
                return (double)left >= (double)right;
            }
        }
        else
        {
            errores.setError("Semantico", "No se puede realizar la operación de comparación", linea, columna);
            return "Error Semantico, No se puede realizar la operación de comparación";
        }
        return null;
    }

    // VisitNot
    public override object VisitNot(AnalizadorParser.NotContext context)
    {
        object value = Visit(context.expr());
        if (value is bool boolValue) return !boolValue;

        throw new Exception("Negation (!) can only be applied to booleans.");
    }

    //IncrementoDecremento
    public override object VisitIncrementoDecremento([NotNull] AnalizadorParser.IncrementoDecrementoContext context)
    {
        //++ | --
        var variable = context.ID().GetText();
        var operador = context.op.Text;
        var variableExistente = currentEnvironment.GetVariable(variable);
        if (variableExistente == null){
            errores.setError("Semantico", "La variable " + variable + " no existe", context.Start.Line, context.Start.Column);
            return "Error Semantico, la variable no existe";
        }
        if (operador == "++")
        {
            if (variableExistente.Value is int)
            {
                variableExistente.Value = (int)variableExistente.Value + 1;
            }
            else if (variableExistente.Value is double)
            {
                variableExistente.Value = (double)variableExistente.Value + 1;
            }
            else
            {
                errores.setError("Semantico", "No se puede incrementar " +variable , context.Start.Line, context.Start.Column);
                return "Error Semantico, error de tipos en la resta";
            }
        }
        else if (operador == "--")
        {
            if (variableExistente.Value is int)
            {
                variableExistente.Value = (int)variableExistente.Value - 1;
            }
            else if (variableExistente.Value is double)
            {
                variableExistente.Value = (double)variableExistente.Value - 1;
            }
            else{
                errores.setError("Semantico", "No se puede decrementar " + variable, context.Start.Line, context.Start.Column);
                return "Error Semantico, error de tipos en la resta";
            }
        }
        currentEnvironment.SetVariable(variable, variableExistente.Value, variableExistente.Type);
        return null;
   
    }
    public override object VisitAsigAddSub(AnalizadorParser.AsigAddSubContext context){
        //AsigAddSub
        // c += 19
        //| ID op = ('+=' | '-=') expr				# AsigAddSub
     
        Console.WriteLine("AsigAddSub");

        var variable = context.ID().GetText();
        var operador = context.op.Text;
        var valor = Visit(context.expr());
        var variableExistente = currentEnvironment.GetVariable(variable);
        if (variableExistente == null)
        {
            errores.setError("Semantico", "La variable " + variable + " no existe", context.Start.Line, context.Start.Column);
            return "Error Semantico, la variable no existe";
        }
        if (operador == "+=")
        {
            if (variableExistente.Value is int && valor is int)
            {
                variableExistente.Value = (int)variableExistente.Value + (int)valor;
            }
            else if (variableExistente.Value is double && valor is double)
            {
                variableExistente.Value = (double)variableExistente.Value + (double)valor;
            }
            else
            {
                errores.setError("Semantico", "No se puede sumar " + variableExistente.Value.GetType().Name + " con " + valor.GetType().Name, context.Start.Line, context.Start.Column);
                return "Error Semantico, error de tipos en la suma";
            }
        }
        else if (operador == "-=")
        {
            if (variableExistente.Value is int && valor is int)
            {
                variableExistente.Value = (int)variableExistente.Value - (int)valor;
            }
            else if (variableExistente.Value is double && valor is double)
            {
                variableExistente.Value = (double)variableExistente.Value - (double)valor;
            }
            else
            {
                errores.setError("Semantico", "No se puede restar " + variableExistente.Value.GetType().Name + " con " + valor.GetType().Name, context.Start.Line, context.Start.Column);
                return "Error Semantico, error de tipos en la resta";
            }
        }
        currentEnvironment.SetVariable(variable, variableExistente.Value, variableExistente.Type);

        
        return null;
    }
    //ExprStmt
    public override object VisitExprStmt(AnalizadorParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    // VisitIfStmt
    public override object VisitIfStmt(AnalizadorParser.IfStmtContext context)
    {
        object condition = Visit(context.expr());

        if (condition is not bool)
            throw new Exception("If statement condition must be a boolean.");

        object ret = null;
        if ((bool)condition)
        {
            Entornos new_environment = new Entornos(currentEnvironment);

            currentEnvironment = new_environment;
            ret = Visit(context.block(0)); // Ejecutar el bloque del 'if'
            currentEnvironment = new_environment.Parent;
        }
        else if (context.block().Length > 1)
        {
            ret = Visit(context.block(1)); // Ejecutar el bloque del 'else' si existe
        }
        else if (context.dcl() != null)
        {
            ret = Visit(context.dcl());
        }

        return ret;
    }
    
    public override object VisitBlockStmt(AnalizadorParser.BlockStmtContext context)
    {
        Entornos previousEnvironment = currentEnvironment;
        currentEnvironment = new Entornos(currentEnvironment);

        foreach (var stmt in context.dcl())
        {
            Visit(stmt);
        }

        currentEnvironment = previousEnvironment;
        return null;
    }
 
 public override object VisitForStmt(AnalizadorParser.ForStmtContext context)
    {
        Entornos EntornoPrevio = currentEnvironment;
        currentEnvironment = new Entornos(currentEnvironment);

        Visit(context.forID());

        VisitForInterno(context);

        currentEnvironment = EntornoPrevio;
        return null;
    }

    public void VisitForInterno(AnalizadorParser.ForStmtContext context)
    {
        object condicion = Visit(context.expr(0));

        var lastEnvironment = currentEnvironment;


        if (condicion is not bool)
        {
            errores.setError("Sintactico", "Condición inválida en el for", context.Start.Line, context.Start.Column);
        }


        try
        {
            while ((bool)condicion )
            {
                Visit(context.block());
                Visit(context.expr(1));
                condicion = Visit(context.expr(0));
            }
        }
        catch (BreakException)
        {
            currentEnvironment = lastEnvironment;
        }
        catch (ContinueException)
        {
            currentEnvironment = lastEnvironment;
            Visit(context.expr(1));
            VisitForInterno(context);
        }

    }
    public override object VisitAsignStmt(AnalizadorParser.AsignStmtContext context)
    {
        var varAsign = context.varAsign();
        string id = varAsign.ID().GetText();
        SymbolType type = Enum.Parse<SymbolType>("Integer");
        object value = Visit(varAsign.expr());

        var VarExistente = currentEnvironment.GetVariable(id);
        if (VarExistente != null)
        {
            currentEnvironment.SetVariable(id, value, VarExistente.Type); // Usa el tipo ya conocido
        }else{
            errores.setError("Semantico", "La variable " + id + " no existe", context.Start.Line, context.Start.Column);
            return "Error Semantico, la variable no existe";
        }

       
        return null;
    }
    //WHILE
    public override object VisitWhileStmt(AnalizadorParser.WhileStmtContext context)
    {
        // object condition = Visit(context.expr());

        // if (condition is not bool)
        //     throw new Exception("If statement condition must be a boolean.");

        while ((bool)Visit(context.expr()))
        {
            Visit(context.block());
        }
        return null;

    }
    
    public override object VisitSwitchStmt(AnalizadorParser.SwitchStmtContext context)
    {
        object switchValue = Visit(context.expr());
        var lastEnvironment = currentEnvironment;

        try{
                // Verificar si hay cases antes de recorrerlos
            if (context.caseList() != null)
            {
                foreach (var caseStmt in context.caseList().caseStmt())
                {
                    if (caseStmt.expr() != null) // Evitar evaluar un expr() nulo
                    {
                        object caseValue = Visit(caseStmt.expr());

                        if (switchValue.Equals(caseValue))
                        {
                            foreach (var stmt in caseStmt.dcl())
                            {
                                Visit(stmt);
                            }
                            return null;
                        }
                    }
                }

                // Verificar si hay un default
                foreach (var caseStmt in context.caseList().caseStmt())
                {
                    if (caseStmt.GetChild(0).GetText() == "default") // Verificar si es default
                    {
                        foreach (var stmt in caseStmt.dcl())
                        {
                            Visit(stmt);
                        }
                        return null;
                    }
                }
            }


        }catch (BreakException)
        {
             currentEnvironment = lastEnvironment;

        }catch (ContinueException)
        {
            currentEnvironment = lastEnvironment;
            Visit(context.expr());
            //VisitSwitchInterno(context);
        }


        
        return null;
    }

}