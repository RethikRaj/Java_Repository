package p09_OOPS.p14_ImmutableClass;

public class ExampleTwo {
    public static void main(String[] args) {
        College c = new College("IIT Madras", "chennai");
        Student s = new Student(20, "Rethik Raj", c);

        // Immutability can be broke in the following ways :

        // Problem 1 : We can change the college name and address using s.getCollege().setName/setAddress
        System.out.println("College name : " + s.getCollege().getName()); // IIT Madras
        
        s.getCollege().setName("IIT Bombay");

        System.out.println("College name : " + s.getCollege().getName()); // IIT Bombay

        // Problem 2 : We can also change the college name and address using the c reference variable
        System.out.println("College name : " + s.getCollege().getName()); // IIT Bombay
        c.setName("IIT Guwahati");
        System.out.println("College name : " + s.getCollege().getName()); // IIT Guwahati


        // These problems exist because we are copying the reference inside the constructor and the getters.
        // Solution 1 : Make the college class immutable.
        // Solution 2 : Defensive copy (deep copy). Instead of copying the reference variable we create new objects and inside the constructor and the getters.
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

class College {
    private String name;
    private String address;

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
    
    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
