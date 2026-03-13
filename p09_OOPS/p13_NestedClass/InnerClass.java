package p09_OOPS.p13_NestedClass;

public class InnerClass {
    public static void main(String[] args) {
        // Object creation 
        // Method 1:
        // Outer o = new Outer();
        // Outer.Inner inner = o.new Inner();

        // method 2:
        Outer.Inner inner = new Outer().new Inner();
        inner.display();
    }
}

class Outer {
    private int x = 10;
    private int z = 50;
    static int y = 20;

    void nonStaticMethod() { System.out.println("nonStaticMethod"); }
    static void staticMethod() { System.out.println("staticMethod"); }

    class Inner {
        // 2. We can have static members inside the inner class from JAVA 16 ( before that it wasn't allowed).
        static int innerY = 30;
        static void innerStaticMethod() { System.out.println("innerStaticMethod"); }

        // 3. Variable shadowing
        int x = 40;

        void display() {
            // 1. Can access both static and non-static members of outer class directly
            System.out.println(x);
            System.out.println(Outer.this.x);
            System.out.println(z); // since not shadowed can be accessed directly
            System.out.println(y);
            nonStaticMethod();
            staticMethod();
        }
    }

}
