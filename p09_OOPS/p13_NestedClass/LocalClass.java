package p09_OOPS.p13_NestedClass;

public class LocalClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.displayTwo();
    }
}

class Outer {
    private int x = 10;
    static int y = 20;

    void nonStaticMethod() { System.out.println("nonStaticMethod"); }
    static void staticMethod() { System.out.println("staticMethod"); }

    Object display() {
        int z = 30; // !4. effectively final — never modified after assignment
        // z += 1;  // uncommenting this causes a compile error

        class Local {
            /*
             * Compiler secretly adds: int z = 30;
             * The value of z is copied into this object at the time of creation.
             * This is why z must be effectively final — the copy is taken once,
             * and if z were allowed to change, the compiler wouldn't know which
             * value to copy (the original or the modified one).
             */
            void print() {
                // 1. Can access both static and non-static members of the outer class
                System.out.println("Outer x  : " + x);
                System.out.println("Outer y  : " + y);
                nonStaticMethod();
                staticMethod();

                // 2. Can access local variables of the enclosing method (must be effectively final)
                System.out.println("Local z (effectively final)    : " + z);
            }
        }

        // 3. Object must be created inside the method where the class is defined
        Local l = new Local();
        l.print();

        return l; // Local object escapes the method — z is gone from stack, but the copy inside the object lives on
    }

    void displayTwo() {
        Object l = display(); // display() is done — z no longer exists on the stack

        // The Local object is still alive on the heap.
        // We can call print() via reflection, proving the object truly outlived the method.
        try {
            var method = l.getClass().getDeclaredMethod("print"); // getDeclaredMethod finds non-public methods too
            method.setAccessible(true); // required to invoke a non-public method via reflection
            method.invoke(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}