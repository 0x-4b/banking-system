/**
 * Interface defining basic operations for a bank account.
 * Any class implementing this interface must provide
 * methods for depositing, withdrawing, and checking balance.
 */
public interface BankInterface {

    /**
     * Deposits a specified amount into the account.
     * @param amount the amount to deposit (should be positive)
     */
    void deposit(double amount);

    /**
     * Withdraws a specified amount from the account.
     * @param amount the amount to withdraw (should be positive and <= balance)
     */
    void withdraw(double amount);

    /**
     * Returns the current balance of the account.
     * @return the account balance
     */
    double getBalance();
}