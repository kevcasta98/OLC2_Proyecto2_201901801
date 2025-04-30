

// BreakException
public class BreakException : Exception
{
    public BreakException() : base("Break statement")
    {
    }
}

// ContinueException
public class ContinueException : Exception
{
    public ContinueException() : base("Continue statement")
    {
    }
}

// ReturnException
public class ReturnException : Exception
{
    public object Value { get; }

    public ReturnException(object value) : base("Return statement")
    {
        Value = value;
    }
}