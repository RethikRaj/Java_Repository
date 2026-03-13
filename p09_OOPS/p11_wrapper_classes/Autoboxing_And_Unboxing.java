package p09_OOPS.p11_wrapper_classes;

public class Autoboxing_And_Unboxing {
    public static void main(String[] args) {
        // Autoboxing : Automatic conversion of a primitive → wrapper object
        int i1 = 10;
        Integer i2 = i1; // Autoboxing
        // Internally java compiler converts the above statement into :
        // Integer i2 = Integer.valueOf(i1); (Modern and fast due to cache optimization)
        // Integer i2 = new Integer(i1); (Old and deprecated)

        System.out.println(i2);

        // Unboxing : Automatic conversion of a wrapper object → primitive
        Integer i3 = Integer.valueOf(20); // autoboxing happens here : 10(int) => 10(Integer)
        int i4 = i3; // Unboxing
        // Internally java compiler converts the above statement into :
        // int i4 = i3.intValue(); 
        System.out.println(i4);

        // Autobxing and unboxing happens on :
        // 1. Assignment operations 
        // 2. Method calling
        // 3. Arithmetic operations

        // 2. Method calling
        printInt(i2);  // i2 is `Integer` but printInt method expects `int` so unboxing happens
        printInteger(i1); // i1 is `int` but printInteger method expects `Integer` so autoboxing happens

        // 3. Arithmetic operations
        int sum = i2 + i3; // i2 and i3 both are `Integer` type => they are unboxed to `int` and then added
        System.out.println(sum);

        // Null Pointer exception
        // Integer i5 = null;
        // int i6 = i5;  // Compiles fine, but throws NullPointerException at runtime because internally it does i5.intValue() => calling a method on null => ERROR
        // System.out.println(i6);
    }

    static void printInt(int x) {
        System.out.println(x);
    }

    static void printInteger(Integer x) {
        System.out.println(x);
    }
}
