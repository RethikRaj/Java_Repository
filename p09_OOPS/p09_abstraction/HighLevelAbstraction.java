// High level abstraction - Achieved using abstract classes or interfaces.

package p09_OOPS.p09_abstraction;

public class HighLevelAbstraction {
    public static void main(String[] args) {

        // Using abstract classes
        // The object creation happens at run time => We separated WHAT ? (accelerate , brake) from HOW ?
        CarAbstractClass c = new FuelCar();
        c.start();
        c.accelerate();
        c.brake();
        c.stop();


        // Using interfaces
        // The object creation happens at run time => We separated WHAT ? (accelerate , brake) from HOW ?
        ICarInterface ic = new ElectricCarI();
        ic.start();
        ic.accelerate();
        ic.brake();
        ic.stop();
    }
}
