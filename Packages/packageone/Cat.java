package Packages.packageone;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(this.name + " makes a meow sound.");
    }
}
