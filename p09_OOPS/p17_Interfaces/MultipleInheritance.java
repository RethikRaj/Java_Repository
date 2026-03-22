package p09_OOPS.p17_Interfaces;

public class MultipleInheritance {
    
}

interface A {
    int x = 10;
    void method1();
    default void hello() {
        System.out.println("A.hello()");
    }
}

interface B {
    int x = 10;
    void method2();
    default void hello() {
        System.out.println("B.hello()");
    }
}

class C implements A, B {
    @Override
    public void method1() {
        System.out.println("C.method1()");
    }

    @Override
    public void method2() {
        System.out.println("C.method2()");
    }

    @Override
    public void hello() {
        // Since both A and B have a default method hello(), 
        // C must override it to resolve the ambiguity.
        A.super.hello();
        B.super.hello();
        System.out.println("C.hello()");

        // variable : Since ambiguous we need to write Interface_name.Var_name.
        System.out.println(A.x); 
        System.out.println(B.x);
    }
}
