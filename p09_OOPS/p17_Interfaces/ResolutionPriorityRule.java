package p09_OOPS.p17_Interfaces;

public class ResolutionPriorityRule {
    public static void main(String[] args) {
        A a = new C();
        a.method1();
        a.hello(); // B.hello()
    }
}

interface A {
    void method1();
    default void hello() {
        System.out.println("A.hello()");
    }
}

class B {
    public void hello() {
        System.out.println("B.hello()");
    }
}

class C extends B implements A {
    @Override
    public void method1() {
        System.out.println("C.method1()");
    }

    // For hello method :
    // 1. No override is needed.
    // 2. Resolution Priority Rule : Class method always takes priority over interface default method.
    // 3. If we need any other behaviour , we should manually override it.
}