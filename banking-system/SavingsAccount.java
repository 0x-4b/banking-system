public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }   





    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("You can't just withdraw money from the void.");
        }
        else {
            double newBalance = getBalance() - amount;
            updateBalance(newBalance);
            System.out.println("Withdrawn " + getBalance() + "$ successfully.");
        }
    }

    public void applyInterest() {
        double newBalance = getBalance() * (1 + interestRate);

        updateBalance(newBalance);
        System.out.println("Interest of " + interestRate + " has been applied to your savings.");
    }
}