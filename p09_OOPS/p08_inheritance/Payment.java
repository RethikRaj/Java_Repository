package p09_OOPS.p08_inheritance;

class Payment {
    private String transactionId;
    private double amount;
    private String currency;

    public Payment(String transactionId, double amount, String currency) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
    }

    // Base implementation — subclasses can override this
    public boolean process() {
        System.out.println("Processing generic payment...");
        return true;
    }
    

    public void printReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount         : " + amount + " " + currency);
        System.out.println("Status         : " + (process() ? "SUCCESS" : "FAILED"));
    }

    public double getAmount() { return amount; }
    public String getTransactionId() { return transactionId; }
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String transactionId, double amount,String currency, String cardNumber, String cardHolder) {
        super(transactionId, amount, currency); // Reuse logic from base class
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean process() {
        super.process(); // using super keyword we can call parent class method
        System.out.println("Processing credit card: **** **** **** " + cardNumber.substring(12));
        // Real logic: call card network API to process payment
        return true;
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(String transactionId, double amount, String currency, String email) {
        super(transactionId, amount, currency); // Using super keyword to call base class constructor
        this.email = email;
    }

    @Override
    public boolean process() {
        super.process(); // using super keyword we can call parent class method
        System.out.println("Processing PayPal payment for: " + email);
        // Real logic: call PayPal API
        return true;
    }
}