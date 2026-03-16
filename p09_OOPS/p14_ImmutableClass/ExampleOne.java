package p09_OOPS.p14_ImmutableClass;

public class ExampleOne {
    public static void main(String[] args) {
        Student s1 = new Student(20, "Rethik Raj");
        System.out.println(s1.getAge());
    }
}

/*
 We think that the below class is purely immutable as we can't change the variables and methods of any object of that class .
 But it is not purely immutable => See Example Two
 */

final class Student {
    private final int age;
    private final String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // getters
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
}