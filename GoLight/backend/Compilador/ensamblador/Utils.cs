//Rune es lo mismo que un entero, trabajarlo como entero
// Cambiar la metadata del stack virtual
// En lib Estandar debemos imprimir el char llamando a la syscall 64
// con longitud de 1. (1:32)
public static class Utils
{
    public static List<byte> StringToBytes(string str)
    {

        var resultado = new List<byte>();//Aqui ira el caracter del resultado en ascci

        int elementoIndex = 0;
        while(elementoIndex < str.Length)
        {
            resultado.Add((byte)str[elementoIndex]);
            elementoIndex++;
            /*var elemento = str[elementoIndex];
            if (elemento == '\\')
            {
                elementoIndex++;
                elemento = str[elementoIndex];
                switch (elemento)
                {
                    case 'n':
                        resultado.Add(0x0A);
                        break;
                    case 't':
                        resultado.Add(0x09);
                        break;
                    case 'r':
                        resultado.Add(0x0D);
                        break;
                    case '\\':
                        resultado.Add(0x5C);
                        break;
                    default:
                        throw new NotImplementedException();
                }*/
          
        }
        resultado.Add(0); // Null terminator
        return resultado;
    }

}