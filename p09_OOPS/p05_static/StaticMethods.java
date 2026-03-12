package p09_OOPS.p05_static;

public class StaticMethods {
    public static void main(String[] args) {
        Student s1 = new Student("Rethik");

        System.out.println(Student.getCollege());
        System.out.println(s1.getCollege());
    }
}

class Student {
    private String name;

    static String college;

    static {
        college = "IIT Madras";
    }

    public Student(String name) {
        this.name = name;
    }

    // Static methods => Cannot access instance variables and instance methods and this keyword. Only can access static variables and  call static methods.
    static String getCollege() {
        return college;
    }
}
