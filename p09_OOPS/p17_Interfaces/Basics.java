package p09_OOPS.p17_Interfaces;

public class Basics {
    public static void main(String[] args) {
        Payment p1 = new SBICreditCardPayment();
        p1.pay();
        p1.cancel();

        p1 = new ICICICreditCardPayment();
        p1.pay();
        p1.cancel();
    }
}

interface Payment {
    void pay(); // compiler will add public abstract
    void cancel(); // compiler will add public abstract
}

abstract class CreditCardPayment implements Payment {
    // Need not override since abstract
}

class SBICreditCardPayment extends CreditCardPayment {
    @Override
    public void pay() {
        System.out.println("SBICreditCardPayment.pay()");
    }

    @Override
    public void cancel() {
        System.out.println("SBICreditCardPayment.cancel()");
    }
}

class ICICICreditCardPayment extends CreditCardPayment {
    @Override
    public void pay() {
        System.out.println("ICICICreditCardPayment.pay()");
    }

    @Override
    public void cancel() {
        System.out.println("ICICICreditCardPayment.cancel()");
    }   
}


