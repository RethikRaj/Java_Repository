package p14_LambdaExpressions.p1_Need_Of_LambdaExpressions;

import java.util.*;

/*
Problem : Still a lot of verbose code and readability worsens.
 */

public class SolutionFour {    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Rethik", 100, 85));
        students.add(new Student("Harry Potter", 101, 99));
        students.add(new Student("Daredevil", 102, 75));
        students.add(new Student("Reacher", 104, 80));
        students.add(new Student("Raj", 105, 85));
    

        // We need to just tell the sort function how to compare so that it can sort => Use Lambda Expressions
        // Collections.sort(students, (s1, s2) -> s1.marks - s2.marks);
        // Collections.sort(students, (s1, s2) -> s1.name.compareTo(s2.name));
        // Collections.sort(students, (s1, s2) -> s1.rollNumber - s2.rollNumber);

        Collections.sort(students, (s1, s2)-> {
            if(s1.marks != s2.marks) {
                return s1.marks - s2.marks;
            } else {
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