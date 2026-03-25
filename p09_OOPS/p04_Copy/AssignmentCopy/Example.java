package p09_OOPS.p04_Copy.AssignmentCopy;

public class Example {
    public static void main(String[] args) {
        // Primitives
        int a = 10;
        int b  = 20;
        b = 30;
        System.out.println(a); // 10
        System.out.println(b); // 30

        // Non-primitives
        Person p1 = new Person(10, "Rethik");
        Person p2 = p1;

        System.out.println(p1 == p2);

        p2.age = 20;
        System.out.println(p1.age);
        System.out.println(p2.age);

        p2.name = "Raj";
        System.out.println(p1.name);
        System.out.println(p2.name);

        System.out.println(p1 == p2); // true
        
    }
}

class Person {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
