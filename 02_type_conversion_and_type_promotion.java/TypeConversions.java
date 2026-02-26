public class TypeConversions {
    public static void ImplicitTypeConversion() {
        // Implicit Type Conversion -> Handled by java compiler
        // All Widening Conversions(size of destination datatype > size of source datatype) are Implicit.
        // Example 1 : (byte -> int)
        byte b = 124;
        int i;
        i = b;
        System.out.println(i);

        // Example 2 : (char -> int)
        char c = 'a';
        i = c;
        System.out.println(i);

        // Example 3 : (float -> double)
        float f = 2.356f;
        double d = f;
        System.out.println(d);

        // Example 4 : (char -> float)
        char c2 = 'b';
        float f2 = c2;
        System.out.println(f2);
    }

    public static void ExplicitTypeConversion() {
        // Explicit Type Conversion -> Done using casting
        // All Narrowing Conversions(size of destination datatype < size of source datatype) are Explicit.
        // Example 1 : (int -> byte), (int->char)
        int i = -130;
        byte b; // Range : -128 to 127
        b = (byte) i;
        System.out.println(b); // 300 % 256 = 44

        char ch = (char) i;
        System.out.println(ch);

        // Example 2 : Truncating Conversion (float/double -> int)
        float f = 3.256f;
        int j;
        j = (int) f;
        System.out.println(j); // 3

    }

    public static void main(String[] args) {
        // Implicit
        ImplicitTypeConversion();

        // Explcit
        ExplicitTypeConversion();

        // Note 
        // 1. Boolean to any other data type is not possible implicitly and explicitly(that is even if type casted it gives error)
        

    }
}
