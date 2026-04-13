package p14_LambdaExpressions.p2_Custom;

import java.util.*;

@FunctionalInterface
interface EmployeeFilter {
    boolean test(Employee employee);
}

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | $" + salary;
    }
}

class EmployeeProcessor {
    public List<Employee> filter(List<Employee> employees, EmployeeFilter filterCriteria) {
        List<Employee> result = new ArrayList<>();

        for(Employee e : employees) {
            if(filterCriteria.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice",   "Engineering", 95000),
            new Employee("Bob",     "Marketing",   60000),
            new Employee("Charlie", "Engineering", 78000),
            new Employee("Diana",   "HR",          55000),
            new Employee("Eve",     "Marketing",   82000)
        );

        EmployeeProcessor employeeProcessor = new EmployeeProcessor();

        // Filter the employees with salary > 75000
        List<Employee> highSalaryEmployees = employeeProcessor.filter(employees, (e) -> e.salary > 75000);
        System.out.println(highSalaryEmployees);

        // Filter by department
        List<Employee> engineers = employeeProcessor.filter(employees, (e) -> e.department.equals("Engineering"));
        System.out.println(engineers);

        
    }
}