package p09_OOPS.p04_Copy.DeepCopy;

public class ExampleOne {
    public static void main(String[] args) throws CloneNotSupportedException {
        Engine e1 = new Engine(200);
        Car car1 = new Car(2020, e1);

        // Method 1 — copy constructor
        Car car2 = new Car(car1);

        // Method 2 — clone()
        Car car3 = (Car) car1.clone();

        // Method 3 — deepCopy()
        Car car4 = car1.deepCopy();

        // Mutate original engine to verify deep copy worked
        car1.engine.horsePower = 999;

        System.out.println(car1.engine.horsePower); // 999
        System.out.println(car2.engine.horsePower); // 200 
        System.out.println(car3.engine.horsePower); // 200 
        System.out.println(car4.engine.horsePower); // 200 
    }
}

class Engine implements Cloneable {
    int horsePower;

    Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    Engine(Engine other) {
        this.horsePower = other.horsePower;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // has only primitives so can do shallow copy.
    }
}

class Car implements Cloneable {
    int year;
    Engine engine;

    Car(int year, Engine engine) {
        this.year = year;
        this.engine = engine;
    }

    // Method 1 to do deep copy
    Car(Car other) {
        // way 1
        this.year = other.year;
        this.engine = new Engine(other.engine); // deep copy

        // way 2
        // this(other.year, new Engine(other.engine));
    }

    // Method 2 to do deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        Car cloned = (Car) super.clone();          // shallow copy of Car fields
        cloned.engine = (Engine) this.engine.clone(); // deep copy the Engine
        return cloned;
    }

    // Method 3 to do deep copy 
    public Car deepCopy() {
        // Way 1
        // Step 1 : Create a new Engine object
        Engine newEngine = new Engine(this.engine);

        // Step 2 : Create a new Car object
        Car newCar = new Car(this.year, newEngine);

        return newCar;

        // way 1 in single line
        // return new Car(this.year, new Engine(this.engine));

        // way 2
        // return new Car(this);
    }
}


