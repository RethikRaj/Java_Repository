package p15_Streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Employee {
    int age;
    int salary;
    String name;

    Employee(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.salary;
    }
}

public class WhyStreams {
    public static void main(String[] args) {
        // problem Statement :
        /*
        Imagine you have a list of employees, and you need to:
            1. Filter only those with salary > 50,000
            2. Get their names
            3. Sort the names alphabetically 
        */

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(25, 75000, "Rethik"));
        employees.add(new Employee(21, 59000, "Daredevil"));
        employees.add(new Employee(22, 40000, "Harry Potter"));
        


        // Without Streams 
        List<String> result = new ArrayList<>();
        for(Employee e : employees) {
            if(e.salary > 50000) {
                result.add(e.name);
            }
        }
        Collections.sort(result);

        System.out.println(result);

        // With Streams
        List<String> answer = employees.stream()
                                        .filter((e) -> e.salary > 50000)
                                        .map((e) -> e.name)
                                        .sorted()
                                        .toList();
        System.out.println(answer);

    }
}
