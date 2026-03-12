package p08_functions;

import java.util.Random;

public class Basics{
    static void greet() {
        System.out.println("Hello, World!");
    }

    static void greetWithName(String name){
        System.out.println("Hello, " + name + "!");
    }

    static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100); // Generates a random number between 0 and 99
    }

    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = sum(4, 5); // Calling a function
        System.out.println(result);
    }
}