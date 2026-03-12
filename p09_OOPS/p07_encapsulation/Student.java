package p09_OOPS.p07_encapsulation;

class Student {
    // Private fields — hidden from outside
    private String name;
    private int age;
    private double gpa;

    // Constructor
    public Student(String name, int age, double gpa) {
        this.name = name;
        setAge(age);     // **reuse validation logic**
        setGpa(gpa);
    }

    // Getters — controlled read access
    public String getName() { return name; }
    public int getAge()     { return age; }
    public double getGpa()  { return gpa; }

    // Setters — validated write access
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100)
            throw new IllegalArgumentException("Invalid age: " + age);
        this.age = age;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 5.0)
            throw new IllegalArgumentException("GPA must be between 0.0 and 5.0");
        this.gpa = gpa;
    }

    public String getLetterGrade() {
        if (gpa >= 4.5) return "A";
        if (gpa >= 3.5) return "B";
        if (gpa >= 2.5) return "C";
        if (gpa >= 1.5) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("Student[%s | Age: %d | GPA: %.1f (%s)]",
                             name, age, gpa, getLetterGrade());
    }
}