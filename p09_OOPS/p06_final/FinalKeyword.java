package p09_OOPS.p06_final;

public class FinalKeyword {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c.PI); // 3.14

        // c.PI = 3.12; // Error : cannot assign a value to final variable
    }
}

class Circle {
    final double PI = 3.14;

    // final can be used inside method parameter
    double getCircumference(final double radius) {
        // cannot change radius inside method
        // radius = 24.5;// error
        return 2 * PI * radius;
    }


    // cannot be overridden inside subclasses
    final double getPI() {
        return PI;
    }
}

// final classes cannot be inherited.
