package p09_OOPS.p10_polymorphism;

public class StaticKeywordPolymorphism {
    public static void main(String[] args) {
        A.print(); // Hello from A
        B.print();  // Hello from B

        A a = new B();
        a.print(); // Hello from A => //**Static methods are bound to reference type and not object type */
        System.out.println(a.name); // Rethik
    }
}

class A {
    static String name = "Rethik";

    static void print() {
        System.out.println("Hello from A");
    }
}

class B extends A {
    static String name = "Raj";

    static void print() {
        System.out.println("Hello from B");
    }
}
