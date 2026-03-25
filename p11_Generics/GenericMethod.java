package p11_Generics;

public class GenericMethod {
    public static void main(String[] args) {
        int result = Identity(10); //  Java infers T = Integer automatically
        System.out.println(result);

        printPair(23, "hello"); // Type T is inferred as `Integer` and U is inferred as `String` by Java
    }

    public static <T> T Identity(T x) {
        return x;
    }

    public static <T, U> void printPair(T x, U y) {
        System.out.println(x + " , " + y);
    }
}


