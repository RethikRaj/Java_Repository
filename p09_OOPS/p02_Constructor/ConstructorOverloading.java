package p09_OOPS.p02_Constructor;


public class ConstructorOverloading {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount("123456789");
        BankAccount ba3 = new BankAccount("123456789", "John Doe");
        BankAccount ba4 = new BankAccount("123456789", "John Doe", 20000);
    }
}

class BankAccount {
    // properties (attributes)
    String accountNumber;
    String owner;
    double balance;

    // constructor
    BankAccount() {

    }

    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
}
