package p09_OOPS.p06_final;

public class GoodExample {
    public static void main(String[] args) {
        // Creating 3 accounts
        BankAccount acc1 = new BankAccount("Aditya Kumar",   10001, 50000);
        BankAccount acc2 = new BankAccount("Rohit Sharma",   10002, 120000);
        BankAccount acc3 = new BankAccount("Priya Mehta",    10003, 75000);

        // Print details for all 3 — notice BANK_NAME and interestRate are same for all
        acc1.printAccountDetails();
        acc2.printAccountDetails();
        acc3.printAccountDetails();

        // Print total accounts — this is a class-level stat
        BankAccount.printTotalAccounts();

        // Bank revises interest rate — changes for ALL accounts instantly
        BankAccount.reviseInterestRate(5.0);

        // Now print again — interest amount has changed for everyone
        acc1.printAccountDetails();
        acc2.printAccountDetails();
        acc3.printAccountDetails();

        // Try changing BANK_NAME — this will cause a compile error
        // BankAccount.BANK_NAME = "HDFC"; // ❌ Error: final field cannot be assigned
    }
}



class BankAccount {

    // -------------------------
    // INSTANCE VARIABLES
    // Every account has its own values for these
    // -------------------------
    String accountHolderName;
    int accountNumber;
    double balance;

    // -------------------------
    // STATIC FINAL — Global Constant
    // Bank name never changes, and is same for all accounts
    // -------------------------
    static final String BANK_NAME = "State Bank of India";

    // -------------------------
    // STATIC — Class Variable
    // Interest rate is same for all accounts, but CAN be revised by the bank
    // -------------------------
    static double interestRate;

    // -------------------------
    // STATIC — Class Variable
    // Counts total accounts created. Shared and updated globally.
    // -------------------------
    static int totalAccounts;

    // -------------------------
    // STATIC BLOCK
    // Runs once when class is loaded. Sets initial static values.
    // -------------------------
    static {
        interestRate = 4.5;  // 4.5% initial rate set by bank
        totalAccounts = 0;
    }

    // -------------------------
    // CONSTRUCTOR
    // Initializes each account's own data
    // Also increments the shared totalAccounts counter
    // -------------------------
    BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++; // every time a new account is created, counter goes up
    }

    // -------------------------
    // INSTANCE METHOD
    // Specific to one account — calculates interest on that account's balance
    // -------------------------
    void printAccountDetails() {
        double interest = (balance * interestRate) / 100;
        System.out.println("-----------------------------");
        System.out.println("Bank       : " + BANK_NAME);
        System.out.println("Account    : " + accountHolderName);
        System.out.println("Acc Number : " + accountNumber);
        System.out.println("Balance    : Rs." + balance);
        System.out.println("Interest   : Rs." + interest + " @ " + interestRate + "%");
    }

    // -------------------------
    // STATIC METHOD
    // Belongs to the bank, not to any one account
    // Used to revise interest rate for ALL accounts at once
    // -------------------------
    static void reviseInterestRate(double newRate) {
        interestRate = newRate;
        System.out.println("\n*** Bank Notice: Interest rate revised to " + interestRate + "% ***\n");
    }

    // -------------------------
    // STATIC METHOD
    // Prints total accounts — bank-level info, not account-level
    // -------------------------
    static void printTotalAccounts() {
        System.out.println("Total Accounts in " + BANK_NAME + " : " + totalAccounts);
    }
}


