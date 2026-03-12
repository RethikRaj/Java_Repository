package p09_OOPS.p02_Constructor;


public class ConstructorChaining {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount("123456789");
        BankAccount ba3 = new BankAccount("123456789", "John Doe");
        BankAccount ba4 = new BankAccount("123456789", "John Doe", 20000);
    }
}

// 1st way -> Every constructor calls the constructor which has all parameters
// class BankAccount {
//     // properties (attributes)
//     String accountNumber;
//     String owner;
//     double balance;

//     // constructor
//     BankAccount() {
//         this("UNKNOWN", "UNKNOWN", 0.0);
//     }

//     BankAccount(String accountNumber) {
//         this(accountNumber, "UNKNOWN", 0.0);
//     }

//     BankAccount(String accountNumber, String owner) {
//        this(accountNumber, owner, 0.0);
//     }

//     BankAccount(String accountNumber, String owner, double balance) {
//         this.accountNumber = accountNumber;
//         this.owner = owner;
//         this.balance = balance;
//     }
// }

// 2nd way -> Every constructor calls the next constructor
class BankAccount {
    // properties (attributes)
    String accountNumber;
    String owner;
    double balance;

    // constructor
    BankAccount() {
        this("UNKNOWN");
    }

    BankAccount(String accountNumber) {
        this(accountNumber, "UNKNOWN");
    }

    BankAccount(String accountNumber, String owner) {
       this(accountNumber, owner, 0.0);
    }

    BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
}