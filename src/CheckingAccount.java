/**
 * Represents a checking account with an overdraft limit.
 * Allows withdrawals that can exceed the balance up to the overdraft limit.
 */
public class CheckingAccount extends BankAccount {

    // The maximum amount the account can be overdrawn
    private double overdraftLimit;

    /**
     * Constructs a CheckingAccount with the specified account number, initial balance, and overdraft limit.
     * @param accountNumber the unique account number
     * @param balance the starting balance for the account
     * @param overdraftLimit the maximum overdraft allowed
     */
    public CheckingAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Withdraws a specified amount from the account.
     * Allows overdrawing up to the overdraft limit.
     * Prints messages for success, overdraft, or insufficient funds.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount){
        // Check if withdrawal exceeds balance plus overdraft limit
        if (amount >= getBalance() + overdraftLimit) {
            System.out.println("You can't withdraw that much buddy.");
        } else {
            double newBalance = getBalance() - amount;
            updateBalance(newBalance);

            System.out.println("Withdrawn " + amount + "$ successfully.");

            // Notify if the account is now overdrawn
            if (newBalance < 0) {
                System.out.println("Just to say my friend, your money's way down (zero or less).");
            }
        }
    }

    /**
     * Returns a string representation of the checking account,
     * including account number, balance, and overdraft limit.
     * @return a string with account details
     */
    @Override
    public String toString() {
        return "No: " + getAccountNumber() + " & Balance: " + getBalance() + " & Overdraft Limit: " + overdraftLimit;
    }
    
}