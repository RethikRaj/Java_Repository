package p14_LambdaExpressions.p1_Need_Of_LambdaExpressions;

import java.util.*;

/*
Problem : I can have only one ordering that will be natural ordering.
 */

public class SolutionOne {    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Rethik", 100, 85));
        students.add(new Student("Harry Potter", 101, 99));
        students.add(new Student("Daredevil", 102, 75));
        students.add(new Student("Reacher", 104, 80));
        
        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.name + " " + student.rollNumber + " " + student.marks);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int rollNumber;
    int marks;

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;
    }

}
