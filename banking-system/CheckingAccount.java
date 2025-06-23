public class CheckingAccount extends BankAccount {

    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount){
        if (amount >= getBalance() + overdraftLimit) {
            System.out.println("You can't withdraw that much buddy.");
        }


        else {
            
            double newBalance = getBalance() - amount;
            updateBalance(newBalance);

            System.out.println("Withdraw " + amount + "$ successfully.");

            if (newBalance < 0) {
                System.out.println("Just to say my friend, your money's way down (zero or less).");
            }
        }
    }
    
}