package p18_MemoryManagement;

// ========== Student.java ==========

public class Student {

    // Static variable — shared by all students
    static String college = "ABC College";

    // Instance variables
    String name;
    int marks;

    // Static block
    static {
        System.out.println("Static block executed");
        college = "XYZ University";
    }

    // Instance block
    {
        System.out.println("Instance block executed for: " + name);
    }

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
        System.out.println("Constructor called for: " + name);
    }

    // Instance method
    String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 70) return "B";
        else return "C";
    }

    // Static method
    static void printCollege() {
        System.out.println("College: " + college);
    }
}