package p18_MemoryManagement;

// ========== StudentApp.java(Entry point)==========

public class StudentApp {
    public static void main(String[] args) {

        Student.printCollege();

        Student s1 = new Student("Alice", 95);
        Student s2 = new Student("Bob", 75);

        System.out.println(s1.name + " Grade: " + s1.getGrade());
        System.out.println(s2.name + " Grade: " + s2.getGrade());

        Student.printCollege();
    }
}
