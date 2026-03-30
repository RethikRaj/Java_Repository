package p11_Generics;

import java.util.ArrayList;
import java.util.List;

public class Extends {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Dog());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        // We can pass List<Animal or subtype> to print function
        print(animals);
        print(dogs);
        // print(integers); // integers are not subclass of animal
        print(cats);

        printTwo(animals);
        printTwo(dogs);
        // printTwo(integers);  // integers are not subclass of animal
        printTwo(cats);
    }

    public static void print(List<? extends Animal> values) {
        // 1. Reading
        Animal a = values.get(0);
        a.walk();
        
        // 2. Writing
        // We can't write anything except null
        values.add(null);
        // values.add(new Dog()); // Problematic because what if the passed values is List<Cats> ( A sibling can't reference to another sibling)
        // values.add(new Animal()); // Problematic because what if the passed values is List<Dogs> or List<Cats> (Child can't reference to Parent)
    }

    public static <T extends Animal> void printTwo(List<T> values) {
        // 1. Reading
        Animal a = values.get(0);
        a.walk();

        // 2. Writing
        // We can't write
        values.add(null);
        // values.add(new Dog()); // Problematic because what if the passed values is List<Cats> ( A sibling can't reference to another sibling)
        // values.add(new Animal()); // Problematic because what if the passed values is List<Dogs> or List<Cats> (Child can't reference to Parent)
    }
}

class Animal {
    void walk() { System.out.println("Walking"); }
}

class Dog extends Animal {
    @Override
    void walk() {System.out.println("DOg walking");}
    void bark() { System.out.println("Barking"); }
}

class Cat extends Animal {
    @Override
    void walk() {System.out.println("Cat walking");}
    void meow() { System.out.println("Meowing"); }
}
