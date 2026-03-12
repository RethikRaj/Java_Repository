package p09_OOPS.p09_abstraction;

abstract class CarAbstractClass {
    // Common 
    void start() {
        System.out.println("Starting car");
    }    

    void stop() {
        System.out.println("Stopping car");
    }

    // Not common
    abstract void accelerate();

    abstract void brake();
}

class FuelCar extends CarAbstractClass {
    @Override
    void accelerate() {
        System.out.println("Fuel car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Fuel car is braking");
    }
}

class ElectricCar extends CarAbstractClass {
    @Override
    void accelerate() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Electric car is braking");
    }
}
