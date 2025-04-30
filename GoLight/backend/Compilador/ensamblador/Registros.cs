public static class Register
{
    // Registros generales (x0 - x30)
    public static string X0 => "x0";
    public static string X1 => "x1";
    public static string X2 => "x2";
    public static string X3 => "x3";
    public static string X4 => "x4";
    public static string X5 => "x5";
    public static string X6 => "x6";
    public static string X7 => "x7";
    public static string X8 => "x8";
    public static string X9 => "x9";
    public static string X10 => "x10";
    public static string X11 => "x11";
    public static string X12 => "x12";
    public static string X13 => "x13";
    public static string X14 => "x14";
    public static string X15 => "x15";
    public static string X16 => "x16";
    public static string X17 => "x17";
    public static string X18 => "x18";
    public static string X19 => "x19";
    public static string X20 => "x20";
    public static string X21 => "x21";
    public static string X22 => "x22";
    public static string X23 => "x23";
    public static string X24 => "x24";
    public static string X25 => "x25";
    public static string X26 => "x26";
    public static string X27 => "x27";
    public static string X28 => "x28";
    public static string X29 => "x29"; // Frame Pointer (FP)
    public static string X30 => "x30"; // Link Register (LR)

    // Alias de propósito especial
    public static string FP => X29;    // Frame Pointer
    public static string LR => X30;    // Link Register
    public static string SP => "sp";   // Stack Pointer
    public static string PC => "pc";   // Program Counter
    public static string XZR => "xzr"; // Zero Register

    // Registros SIMD/Floating Point (v0 - v31)
    public static string V0 => "v0";
    public static string V1 => "v1";
    public static string V2 => "v2";
    public static string V3 => "v3";
    public static string V4 => "v4";
    public static string V5 => "v5";
    public static string V6 => "v6";
    public static string V7 => "v7";
    public static string V8 => "v8";
    public static string V9 => "v9";
    public static string V10 => "v10";
    public static string V11 => "v11";
    public static string V12 => "v12";
    public static string V13 => "v13";
    public static string V14 => "v14";
    public static string V15 => "v15";
    public static string V16 => "v16";
    public static string V17 => "v17";
    public static string V18 => "v18";
    public static string V19 => "v19";
    public static string V20 => "v20";
    public static string V21 => "v21";
    public static string V22 => "v22";
    public static string V23 => "v23";
    public static string V24 => "v24";
    public static string V25 => "v25";
    public static string V26 => "v26";
    public static string V27 => "v27";
    public static string V28 => "v28";
    public static string V29 => "v29";
    public static string V30 => "v30";
    public static string V31 => "v31";
}
