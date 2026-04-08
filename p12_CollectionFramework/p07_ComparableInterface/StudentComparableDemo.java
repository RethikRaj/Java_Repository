package p12_CollectionFramework.p07_ComparableInterface;

import java.util.*;

public class StudentComparableDemo {
    public static void main(String[] args) {

        Student s1 = new Student("Rethik", 99);
        Student s2 = new Student("Raj", 95);
        Student s3 = new Student("Harry Potter", 85);
        Student s4 = new Student("Daredevil", 95);


        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Collections.sort(list);

        for(Student s : list) {
            System.out.println(s.marks + " " + s.name);
        }

        // Dangers of '0' return
        TreeSet<Student> set = new TreeSet<>(); // internally uses compareTo()
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        for(Student s : set) {
            System.out.println(s.marks + " " + s.name);
        }

    }
}

class Student implements Comparable<Student> {
    int marks;
    String name;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // @Override
    // public int compareTo(Student other) {
    //     return this.marks - other.marks;
    // }

    @Override
    public int compareTo(Student other) {
        if(this.marks == other.marks) {
            return this.name.compareTo(other.name);
        }
        return this.marks - other.marks;
    }
}
