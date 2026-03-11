package Packages.packageone;

public class Dog {
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public void fetch() {
        System.out.println(this.breed + " fetches the ball!");
    }
}
