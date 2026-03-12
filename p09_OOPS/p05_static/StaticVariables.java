package p09_OOPS.p05_static;

public class StaticVariables {
    public static void main(String[] args) {
        // Example 1 
        Student s1 = new Student("Rethik", (byte) 10);

        System.out.println(Student.college);
        System.out.println(s1.college);
        
    }
}

class Student {
    private String name;
    private byte age;

    static String college; // shared by all Student objects.

    static int totalStudents = 0; // 1st way of initializing static variable

    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
        // college = "IIT Madras"; // 2nd way of initializing static variable
        totalStudents++;
    }

    // static block -> can write logic ( BEST )
    static {
        // String city = System.getenv("CITY"); // reads environment variable
        // For now i am hardcoding it
        String city = "Chennai";

        if (city.equals("Chennai")) {
            college = "IIT Madras"; // 3rd way of initializing static variable
        } else {
            college = "IIT Bombay";
        }
    }
}

