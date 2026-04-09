package p14_LambdaExpressions.p1_Need_Of_LambdaExpressions;

import java.util.*;

/*
Problem : Still a lot of verbose code and readability worsens.
 */

public class SolutionThree {    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Rethik", 100, 85));
        students.add(new Student("Harry Potter", 101, 99));
        students.add(new Student("Daredevil", 102, 75));
        students.add(new Student("Reacher", 104, 80));
    

        // Create anonymous classes
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.marks - s2.marks;
            }
        });

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });

        for (Student student : students) {
            System.out.println(student.name + " " + student.rollNumber + " " + student.marks);
        }
    }
}

class Student  {
    String name;
    int rollNumber;
    int marks;

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
}