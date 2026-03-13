package p09_OOPS.p12_POJO;

public class Anemic {
    
}

class Student {
    // 1. fields
    private String name;
    private int age;
    private int rollNumber;
    private String college;

    // 2.Constructor
    Student(String name, int age, int rollNumber, String college) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
    }

    // 3. Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // ... (same for other fields)
}
