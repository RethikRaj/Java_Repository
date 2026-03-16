package p09_OOPS.p14_ImmutableClass;

public class SolutionTwo {
    public static void main(String[] args) {
        College c = new College("IIT Madras", "chennai");
        Student s = new Student(20, "Rethik Raj", c);

        // Immutability can never be broke

        // try 1
        System.out.println("College name : " + s.getCollege().getName()); // IIT Madras
        
        s.getCollege().setName("IIT Bombay");

        System.out.println("College name : " + s.getCollege().getName()); // IIT Madras

        // try 2 :
        System.out.println("College name : " + s.getCollege().getName()); // IIT Madras
        c.setName("IIT Guwahati");
        System.out.println("College name : " + s.getCollege().getName()); // IIT Madras

    }
}

final class Student {
    private final int age;
    private final String name;

    private final College college;

    public Student(int age, String name,College college) {
        this.age = age;
        this.name = name;
        this.college = new College(college.getName(), college.getAddress()); // deep copy
    }

    // getters
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public College getCollege() {
        return new College(this.college.getName(), this.college.getAddress()); // deep copy
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

