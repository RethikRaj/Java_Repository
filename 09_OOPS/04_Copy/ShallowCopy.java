public class ShallowCopy {
    public static void main(String[] args) {
        Car original = new Car(2024, new Engine(200));

        Car shallowCopy = new Car(original);

        shallowCopy.engine.horsePower = 300;

        // The change is impacted in both objects
        System.out.println(original.engine.horsePower);
        System.out.println(shallowCopy.engine.horsePower);
    }
}

class Engine {
    int horsePower;

    Engine(int horsePower) {
        this.horsePower = horsePower;
    }
}

class Car {
    int year;
    Engine engine;

    Car(int year, Engine engine) {
        this.year = year;
        this.engine = engine;
    }

    // Shallow Copy
    Car(Car other) {
        this.year = other.year;
        this.engine = other.engine; // ← just copies the reference!
    }
}
