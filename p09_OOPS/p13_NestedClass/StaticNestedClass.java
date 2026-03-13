package p09_OOPS.p13_NestedClass;

public class StaticNestedClass {
    public static void main(String[] args) {
        // object creation 
        Outer.Inner inner = new Outer.Inner();
        inner.display();
    }
}

class Outer {
    private int x = 10;
    static int y = 20;

    void nonStaticMethod() { System.out.println("nonStaticMethod"); }
    static void staticMethod() { System.out.println("staticMethod"); }

    static class Inner {

        // 3. We can have static members inside the inner class
        static int innerY = 30;
        static void innerStaticMethod() { System.out.println("innerStaticMethod"); }

        void display() {
            // 1. We can access the static members (variables and methods) of outer classdirectly.
            System.out.println(y);
            staticMethod();

            // 2. We cannot access non-static members of outer class directly.
            // System.out.println(x);
            // nonStaticMethod();
        }

        void displayTwo(Outer o) {
            // 4. To access non-static members of outer class we need to pass the outer object as paramater or we need to keep a field Outer obj inside inner class.
            System.out.println(o.x);
            o.nonStaticMethod();
        }
    }
}