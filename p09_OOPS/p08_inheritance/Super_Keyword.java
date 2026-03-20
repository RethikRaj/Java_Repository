package p09_OOPS.p08_inheritance;

public class Super_Keyword {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}

class Parent {
    int x = 10;
    int y = 30;
    void greet() {
        System.out.println("Hello from parent");
    }
    void fun() {
        System.out.println("Parent having fun");
    }
}

class Child extends Parent {
    int x = 20;
    void greet() {
        System.out.println("Hello from child");
    }

    void display() {
        System.out.println(x); // 20
        System.out.println(super.x); // 10

        System.out.println(y); // No need to explicitly write super.y
        
        greet(); // "Hello from child"
        super.greet(); // "Hello from parent"

        fun(); // No need to explicitly write super.fun()
    }
}
