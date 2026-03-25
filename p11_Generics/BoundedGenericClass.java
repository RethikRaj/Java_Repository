package p11_Generics;

// Generics
// 1. No restriction => T acts as Object inside the Generic class . So we can call only the methods of Object class.
// 2. With Restriction => T is restricted so we can call methods on that restricted type which are allowed on the restricted type.

public class BoundedGenericClass {
    public static void main(String[] args) {
        BoxWithNoRestriction<String> b1 = new BoxWithNoRestriction<>("Hello");
        b1.allowedFunctions();

        NumberBox<Float> b2 = new NumberBox<>(12.5f);
        b2.allowedFunctions();

        // AnimalSwimBreatheBox<Animal> b3 = new AnimalSwimBreatheBox<>(new Dog()); 
        // AnimalSwimBreatheBox<Dog> b3 = new AnimalSwimBreatheBox<>(new Dog()); 
        AnimalSwimBreatheBox<Fish> b3 = new AnimalSwimBreatheBox<>(new Fish()); 
        b3.performActions();
    }
}

class BoxWithNoRestriction<T> {
    private T value;

    BoxWithNoRestriction(T value) {
        this.value = value;
    }

    public void allowedFunctions() {
        System.out.println(value.toString());
        System.out.println(value.hashCode());
        System.out.println(value.getClass().getName());
        // ... 
    }
} 

// Problem Statement 1 : Create a Box class which can hold any Number value
// < T extends Number > => T can be Number or any of its subtype.

class NumberBox <T extends Number> {
    private T value;

    NumberBox(T value) {
        this.value = value;
    }

    public void allowedFunctions() {
        System.out.println(value.toString());

        System.out.println(value.doubleValue()); // can't be done with unrestricted generic class
        System.out.println(value.floatValue()); // can't be done with unrestricted generic class
        System.out.println(value.intValue()); // can't be done with unrestricted generic class
    }
}

// Problem Statment 2 : Create a Box class which can hold a value of type which extends animal and implements swimmable class and Breathable
interface Swimmable { void Swim(); } 
interface Breathable { void Breath(); }

class Animal {}
class Dog extends Animal {}
class Fish extends Animal implements Swimmable , Breathable{
    @Override
    public void Swim() {
        System.out.println("Fish is swimming");
    }
    @Override
    public void Breath() {
        System.out.println("Fish is breathing");
    }
}

class AnimalSwimBreatheBox<T extends Animal & Swimmable & Breathable> {
    private T value;

    AnimalSwimBreatheBox(T value) {
        this.value = value;
    }

    public void performActions() {
        value.Swim();
        value.Breath();
        System.out.println("Class: " + value.getClass().getSimpleName());
    }
}