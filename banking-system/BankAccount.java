public abstract class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a positive number.");
        }
        else {
            balance += amount;
            System.out.println("Deposited " + amount + "$ successfully.");
        }
    }


    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("You can't take money from the void.");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawn " + amount + "$ successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }


    @Override
    public String toString() {
        return "Num: " + accountNumber + " & Balance: " + balance;
    }

}