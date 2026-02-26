public class PrimitiveDataTypes {
    public static void main(String[] args) {
        // Integers -> byte, short , int , long
        byte b_decimal = 17; // ( DECIMAL )
        byte b_binary = 0b10001; // ( BINARY )
        byte b_octal = 021; // ( OCTAL )
        byte b_hexadecimal = 0x11; // ( HEXADECIMAL )

        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        long l2 = 10_12_224; // Reading purposes

        // Floating Point -> float(Single precision) , double(Double precision)
        float f = 4.345f; // 
        double d_standard = 4.3456789; // Standard way
        double d_scientific = 6.022e23; // Scientific way (Example : 6.022 * 10^23)

        // Charater -> char
        // Storing a character in memory : char-> integer->binary-> store
        // Retrieving : using the datatype we get to know whether the stored binary represents an integer value or a character value 
        char c = 'a'; 

        // Boolean -> boolean
        boolean b = true;

        System.out.println("Integer Values ---> " + b_decimal + " " + b_binary + " " + b_octal + " " + b_hexadecimal + " " + s + " " + i + " " + l + " " + l2);
        System.out.println("Floating Point Values ---> " + f + " " + d_standard + " " + d_scientific);
        System.out.println("Character Values ---> " + c);
        System.out.println("Boolean Values ---> " + b);
    }
}
