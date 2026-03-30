package p11_Generics;

import java.util.ArrayList;
import java.util.List;

/*
 We know that Generics are invariant.
 But what if we need to define a method which accepts a list of any type of animal.
 */

public class WildCards {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        // We can pass any type of list to print function
        print(animals);
        print(dogs);
        print(integers);

        printTwo(animals);
        printTwo(dogs);
        printTwo(integers);

    }

    public static void print(List<?> values) {
        // 1. Reading 
        // 1.1) Only via Object clas
        Object o = values.get(0);
        System.out.println(o.getClass().getName());
        // 1.2) If we want animal functionality , then we need to do downcasting, which can lead to run time error.(ClassCastException)
        // Animal a = (Animal) (o);
        // a.walk();

        // 2. Writing 
        // 2.1) We can't write because List<?> may be anything and we might insert some wrong type in it, therefore Java won't allow us to write.
        // values.add(new Dog());
        // 2.2) We can write null
        values.add(null);
    }

    public static <T> void printTwo(List<T> values) {
        // 1. Reading 
        // 1.1) Only via Object clas
        Object o = values.get(0);
        System.out.println(o.getClass().getName());
        // 1.2) If we want animal functionality , then we need to do downcasting, which can lead to run time error.(ClassCastException)
        // Animal a = (Animal) (o);
        // a.walk();

        // 2. Writing 
        // 2.1) We can't write because List<T> may be anything and we might insert some wrong type in it, therefore Java won't allow us to write.
        // values.add(new Dog());
        // 2.2) We can write null
        values.add(null);
    }
}

class Animal {
    void walk() { System.out.println("Walking"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}
