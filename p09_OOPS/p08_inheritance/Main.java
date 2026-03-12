package p09_OOPS.p08_inheritance;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Payment> payments = List.of(
            new CreditCardPayment("TXN001", 99.99, "USD", "1234567812345678", "rethik"),
            new PayPalPayment("TXN002", 49.50,"USD", "rethik@example.com")
        );

        for (Payment payment : payments) {
            payment.printReceipt();
            System.out.println();
        }
    }
}