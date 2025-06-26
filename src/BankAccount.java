/**
 * Abstract class representing a generic bank account.
 * Provides basic functionality for deposit and balance management.
 * Subclasses must implement the withdraw method.
 */
public abstract class BankAccount implements BankInterface {
    // Unique identifier for the bank account
    private int accountNumber;
    // Current balance of the account
    private double balance;

    /**
     * Constructs a new BankAccount with the given account number and initial balance.
     * @param accountNumber the unique account number
     * @param balance the starting balance for the account
     */
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Deposits a positive amount into the account.
     * Prints a message indicating success or failure.
     * @param amount the amount to deposit (must be positive)
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a positive number.");
            return;
        } else {
            balance += amount;
            System.out.println("Deposited " + amount + "$ successfully.");
        }
    }

    /**
     * Abstract method for withdrawing money from the account.
     * Must be implemented by subclasses to define specific withdrawal rules.
     * @param amount the amount to withdraw
     */
    public abstract void withdraw(double amount);

    /**
     * Gets the account number.
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the account.
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the account balance to a new value.
     * @param newBalance the new balance to set
     */
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Returns a string representation of the account, showing the account number and balance.
     * @return a string with account details
     */
    @Override
    public String toString() {
        return "No: " + accountNumber + " & Balance: " + balance;
    }
}