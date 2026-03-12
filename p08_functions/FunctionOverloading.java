package p08_functions;

public class FunctionOverloading {
    public static void main(String[] args) {
        
    }

    // 1. Based on number of parameter
    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // 2. Based on data type of parameter
    static int sum(int a, double b) {
        return a + (int)b;
    }

    // 3. Based on order of parameter
    static int sum(double a, int b) {
        return (int)a + b;
    }

    // Note : functions cannot be overloaded based solely on their return type
}
