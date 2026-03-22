package p09_OOPS.p17_Interfaces;

public class InterfaceInheritance {
    public static void main(String[] args) {
    }
}

interface A {
    void method1();
    default void hello() {
        System.out.println("A.hello()");
    }
}

interface B {
    void method2();
    default void hello() {
        System.out.println("B.hello()");
    }
}

interface C extends A, B {
    void method3();

    @Override
    default void hello() { // must be overrided 
        A.super.hello();
        B.super.hello();
        System.out.println("C.hello()");
    }
}

