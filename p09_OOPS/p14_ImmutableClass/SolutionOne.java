package p09_OOPS.p14_ImmutableClass;

public class SolutionOne {
    public static void main(String[] args) {
        College c = new College("IIT Madras", "chennai");
        Student s = new Student(20, "Rethik Raj", c);

        System.out.println(s.getCollege().getName());
        System.out.println(s.getCollege().getAddress());
        System.out.println(s.getName());
        System.out.println(s.getAge());
        
    }
}

final class Student {
    private final int age;
    private final String name;

    private final College college;

    public Student(int age, String name,College college) {
        this.age = age;
        this.name = name;
        this.college = college; // shallow copy
    }

    // getters
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public College getCollege() {
        return this.college; // shallow copy.
    }
}

final class College {
    private final String name;
    private final String address;

    College(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}

