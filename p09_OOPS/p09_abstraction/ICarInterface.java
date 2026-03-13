package p09_OOPS.p09_abstraction;

interface ICarInterface {

    void start();
    void accelerate();
    void brake();
    void stop();
}

class FuelCarI implements ICarInterface {
    @Override
    public void start() {
        System.out.println("Starting fuel car");
    }

    @Override
    public void accelerate() {
        System.out.println("Fuel car is accelerating");
    }

    @Override
    public void brake() {
        System.out.println("Fuel car is braking");
    }

    @Override
    public void stop() {
        System.out.println("Stopping fuel car");
    }
}

class ElectricCarI implements ICarInterface {
    @Override
    public void start() {
        System.out.println("Starting electric car");
    }

    @Override
    public void accelerate() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    public void brake() {
        System.out.println("Electric car is braking");
    }

    @Override
    public void stop() {
        System.out.println("Stopping electric car");
    }
}