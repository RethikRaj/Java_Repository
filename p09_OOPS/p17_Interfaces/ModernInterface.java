package p09_OOPS.p17_Interfaces;

/* 
After java 8 :
1. We can have default methods in interfaces with body.
2. We can have static methods in interfaces with body. (Not inherited)
After java 9 :
1. We can have private methods in interfaces with body. It can only be used inside the interface.
 */

public class ModernInterface {
    public static void main(String[] args) {
        Parent p = new Child();
        p.method1();
        p.method2();
        Parent.method3();
        Child.method3();
    }
}

interface Parent {
    void method1(); // compiler adds public abstract

    // Note : This default has nothing to do with the `default` access modifier.
    // For this method the access modifier is still public , but the method is not abstract.
    default void method2() {
        method4(); // private method can only be used internally.
        System.out.println("Parent.method2() : Some default implementation.");
    }

    static void method3(){
        System.out.println("Parent.method3()");
    }

    private void method4() {
        System.out.println("Parent.method4()");
    }
}

class Child implements Parent {
    @Override
    public void method1() { // method1 must be overriden 
        System.out.println("Child.method1()");
    }

    // @Override
    // public void method2() { // method2 can be overriden , it is not must.
    //     System.out.println("Child.method2()");
    // }


    public static void method3() { // This is not overriding. 
        System.out.println("Child.method3()");
    }
}