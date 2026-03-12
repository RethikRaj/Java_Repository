package p09_OOPS.p04_Copy;


public class DeepCopy {
    public static void main(String[] args) {
        Car original = new Car(2024, new Engine(200));

        Car deepCopy = new Car(original);

        deepCopy.engine.horsePower = 300;

        // The change is not impacted in both objects
        System.out.println(original.engine.horsePower);
        System.out.println(deepCopy.engine.horsePower);
    }
}

class Engine {
    int horsePower;

    Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    //  Deep copy constructor
    Engine(Engine other) {
        this.horsePower = other.horsePower;
    }
}

class Car {
    int year;
    Engine engine;

    Car(int year, Engine engine) {
        this.year = year;
        this.engine = engine;
    }

    // Deep Copy
    Car(Car other) {
        this.year = other.year;
        this.engine = new Engine(other.engine); // ← new Engine!
    }
}
