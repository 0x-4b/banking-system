public abstract class BankAccount implements BankInterface{
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


    public abstract void withdraw(double amount);

    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }

    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }


    @Override
    public String toString() {
        return "Num: " + accountNumber + " & Balance: " + balance;
    }

}