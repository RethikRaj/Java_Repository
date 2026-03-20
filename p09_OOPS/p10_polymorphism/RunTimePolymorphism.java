// Run Time polymorphism => Method overriding

package p09_OOPS.p10_polymorphism;

import java.util.Scanner;

public class RunTimePolymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type of animal : 1. Dog 2. Duck 3. Human : ");
        int choice = sc.nextInt();
        sc.close();

        Animal a = null;
        if (choice == 1) {
            a = new Dog(); // object creation happens at runtime.
        } else if (choice == 2) {
            a = new Duck();
        } else if (choice == 3) {
            a = new Man();
        }

        a.run();
    }
}

abstract class Animal {
    abstract void run();
}

class Dog extends Animal {
    @Override
    void run() { System.out.println("Dog runs on 4 legs"); }
}

class Duck extends Animal {
    @Override
    public void run() { System.out.println("Duck waddles"); }
}

class Man extends Animal {
    @Override
    public void run() { System.out.println("Man runs on 2 legs"); }
}
