package p11_Generics;

import java.util.ArrayList;
import java.util.List;

public class ProblemsWithGenerics {
    public static void main(String[] args) {
        // 1. Normally the following line is allowed in java
        Animal a = new Dog();
        a.walk();

        // 2. But the following is not allowed using generics => Generics break the parent-child relationship
        // Generics are covariant but safe.
        // List<Dog> dogs = new ArrayList<>();
        // List<Animal> animals = dogs;

        // 3. Using arrays
        // Arrays are invariant but unsafe.
        Dog[] dogs = new Dog[10];
        Animal[] animals = dogs; // Allowed

        // But we will get a run time error if we insert an animal
        animals[0] = new Animal(); // Run time error : ArrayStoreException

    }
}

class Animal {
    void walk() { System.out.println("Walking"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}
