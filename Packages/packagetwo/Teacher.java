package Packages.packagetwo;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void teach() {
        System.out.println(this.name + " is teaching " + this.subject + ".");
    }
}
