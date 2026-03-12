package p09_OOPS.p01_Basics;

public class Basics {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone(); // s1 is a reference variable

        // Default values
        System.out.println(s1.name); // null
        System.out.println(s1.price); // 0.0
        System.out.println(s1.brand); // null

        // Set values
        s1.name = "Samsung M12";
        s1.price = 20000;
        s1.brand = "Samsung";

        s1.displayDetails();

        SmartPhone s2 = new SmartPhone();
        s2.name = "Samsung M14";
        s2.price = 20000;
        s2.brand = "Samsung";

        s1.makeCall(s2);
    }
}

class SmartPhone {
    // properties (attributes)
    String name;
    double price;
    String brand;

    // methods (behaviour + additional functionality(like displaying, ...))
    void makeCall(SmartPhone other) {
        System.out.println("Calling " + other.name);
    }

    void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}

class BankAccount {
    // properties (attributes)
    String accountNumber;
    String owner;
    double balance;

    // methods (behaviour + additional functionality(like displaying, ...))
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " | New balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " | New balance: $" + balance);
        }
    }
}