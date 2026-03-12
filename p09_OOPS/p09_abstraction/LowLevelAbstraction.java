// Low level abstraction - Achieved using normal classes + encapsulation.

package p09_OOPS.p09_abstraction;

public class LowLevelAbstraction {
    public static void main(String[] args) {
        Car c = new Car("TOYOTA HYRYDER");
        c.start(); // Here we don't know how car starts but we know that using this function we can start car
        c.accelerate();
        c.brake();
        c.stop();
    }
}

// Assume this is black box.
class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void start() {
        System.out.println("Starting car : " + model);
        // logic for starting ...
    }

    public void accelerate() {
        System.out.println("Accelerating car : " + model);
        // logic for accelerating ...
    }

    public void brake() {
        System.out.println("Braking car : " + model);
        // logic for braking ...
    }

    public void stop() {
        System.out.println("Stopping car : " + model);
        // logic for stopping ...
    }

}