package p09_OOPS.p04_Copy.ShallowCopy;

/*
Shallow Copy : 
1. Creates a new object, but copies field values as-is. 
2. For primitive fields, values are copied. 
3. For object/reference fields, only the reference is copied (not the nested object itself).
*/

// Learning from this code:
// 1. Shallow copy with mutable objects.
// 2. Ways to do shallow copy.

public class ExampleOne {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car c1 = new Car(2020, new Engine(120));
        Car c2 = new Car(c1); // shallow copy
        Car c3 = (Car) c1.clone(); // shallow copy
        Car c4 = c1.shallowCopy(); // shallow copy


        System.out.println(c1.engine == c2.engine); // true
        System.out.println(c1.engine == c3.engine); // true
        System.out.println(c1.engine == c4.engine); // true
        
        // Changing the horsepower of c2 , it will affect all.
        c2.engine.horsePower = 150;

        System.out.println(c1.engine.horsePower);
        System.out.println(c2.engine.horsePower);
        System.out.println(c3.engine.horsePower);
        System.out.println(c4.engine.horsePower);
    }
}

class Engine {
    int horsePower;

    Engine(int horsePower) {
        this.horsePower = horsePower;
    }
}

class Car implements Cloneable {
    int year;
    Engine engine;

    Car(int year, Engine engine) {
        this.year = year;
        this.engine = engine;
    }

    // Method 1 to do shallow copy
    Car(Car other) {
        this.year = other.year;
        this.engine = other.engine; // ← just copies the reference!

        // this(other.year, other.engine);
    }

    // Method 2 to do shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // does shallow copy
    }

    // Method 3 to do shallow copy
    public Car shallowCopy() {
        return new Car(this.year, this.engine); // way1
        
        // return new Car(this); // way2
    }
}

