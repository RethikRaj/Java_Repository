package p09_OOPS.p17_Interfaces;

public class VariablesInsideInterface {
    public static void main(String[] args) {
        
    }
}

interface A {
    int x = 10; // Compiler will add `public static final`
}

interface MathConstants {
    double PI = 3.141592653589793;
    double E = 2.718281828459045;
    double SQRT2 = 1.414213562373095;
    double SQRT3 = 1.732050807568877;
}

class Circle implements MathConstants {
    void display() {
        System.out.println(PI);
    }
}


