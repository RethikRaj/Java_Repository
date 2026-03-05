public class Constructors {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("123456789", "John Doe", 20000);
    }
}

class BankAccount {
    // properties (attributes)
    String accountNumber;
    String owner;
    double balance;

    // constructor
    BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
}