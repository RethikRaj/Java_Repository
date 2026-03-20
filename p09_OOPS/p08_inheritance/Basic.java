package p09_OOPS.p08_inheritance;

public class Basic {
    public static void main(String[] args) {
        // Normal object — uses Payment's own process()
        Payment p1 = new Payment("TXN001", 500.0, "USD");
        p1.printReceipt();

        // Upcasting — reference is Payment, object is CreditCardPayment(any child)
        // *Using the p2 reference variable, we can only access members defined in the Payment class. However, if the child class overrides a method, the overridden version is called at runtime — because methods are polymorphic. Variables are not polymorphic; the reference type determines which variable is accessed.

        Payment p2 = new CreditCardPayment("TXN002", 1000.0, "USD", "1234567890123456");
        p2.printReceipt();

        // Downcasting — getting back the child type from parent reference
        // *Using the p3 reference variable, we can access all members of both CreditCardPayment and Payment classes, since p3 is of the child type. The overridden process() method still runs the child's version — polymorphism is retained after downcasting.
        CreditCardPayment p3 = (CreditCardPayment) p2;
        p3.printReceipt();
    }
}

// Parent class
class Payment {
    private String transactionId;
    private double amount;
    private String currency;

    public Payment(String transactionId, double amount, String currency) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
    }

    public boolean process() {
        System.out.println("Processing generic payment...");
        return true;
    }

    public void printReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount         : " + amount + " " + currency);
        // process() here is polymorphic — calls child's version if overridden
        System.out.println("Status         : " + (process() ? "SUCCESS" : "FAILED"));
    }
}

// Child class — inherits everything from Payment
class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String transactionId, double amount, String currency, String cardNumber) {
        super(transactionId, amount, currency); // inheriting parent constructor logic
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean process() {
        super.process(); // calling parent's version first
        System.out.println("Processing credit card: **** **** **** " + cardNumber.substring(12));
        return true;
    }
}