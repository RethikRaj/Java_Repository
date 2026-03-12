// Compile Time polymorphism => Method overriding

package p09_OOPS.p10_polymorphism;

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Human human = new Human();
        human.run();
        human.run(true);
    }
}

class Human {
    void run() {
        System.out.println("Running at 2 km/hr");
    }

    void run(boolean isDogBehind) {
        if (isDogBehind)
            System.out.println("Running at 5 km/hr!");
    }
}
