/**
 * Represents a savings account that earns interest.
 * Allows withdrawals only up to the available balance and supports applying interest.
 */
public class SavingsAccount extends BankAccount {

    // The interest rate for this savings account (e.g., 0.05 for 5%)
    private double interestRate;

    /**
     * Constructs a SavingsAccount with the specified account number, initial balance, and interest rate.
     * @param accountNumber the unique account number
     * @param balance the starting balance for the account
     * @param interestRate the interest rate (as a decimal, e.g., 0.03 for 3%)
     */
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    /**
     * Withdraws a specified amount from the account.
     * Only allows withdrawal if sufficient funds are available.
     * Prints a message if withdrawal is successful or if funds are insufficient.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("You can't just withdraw money from the void.");
        } else {
            double newBalance = getBalance() - amount;
            updateBalance(newBalance);
            System.out.println("Withdrawn " + amount + "$ successfully.");
        }
    }

    /**
     * Applies interest to the current balance.
     * Updates the balance and prints a confirmation message.
     */
    public void applyInterest() {
        double newBalance = getBalance() * (1 + interestRate);
        updateBalance(newBalance);
        System.out.println("Interest of " + interestRate + " has been applied to your savings.");
    }

    /**
     * Returns a string representation of the savings account,
     * including account number, balance, and interest rate.
     * @return a string with account details
     */
    @Override
    public String toString() {
        return "No: " + getAccountNumber() + " & Balance: " + getBalance() + " & Interest: " + interestRate;
    }
}