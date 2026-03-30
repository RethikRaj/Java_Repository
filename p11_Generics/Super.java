package p11_Generics;

import java.util.ArrayList;
import java.util.List;

public class Super {
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

        List<Object> objects = new ArrayList<>();

        //  We can pass List<Animal or superType> to print function
        print(animals);
        // print(dogs); // dogs is not an Animal or of its supertype
        // print(integers); //  integers is not an Animal or of its supertype
        // print(cats); //  cats is not an Animal or of its supertype
        print(objects);

    }

    public static void print(List<? super Animal> values) {
        // 1. Reading
        // 1.1) Only via Object clas
        Object o = values.get(0);
        System.out.println(o.getClass().getName());
        // 1.2) If we want animal functionality , then we need to do downcasting, which can lead to run time error.(ClassCastException)
        // Animal a = (Animal) (o);
        // a.walk();

        // 2. Writing
        // We can add animal type or any of its subtype and null.
        values.add(new Animal());
        values.add(new Dog());
        values.add(new Cat());
        values.add(null);

        // values.add(new Object()); // Problematic because what if the passed values is List<Animals> ( A child can't refer to parent).
        // values.add(new String()); // Not allowed
    }

    // Super can't be used with named type parameter
    // public static <T super Animal> void printTwo(List<T> values) {
    // }
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