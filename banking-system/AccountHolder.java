import java.util.ArrayList;

public class AccountHolder {

    private String name;
    private String email;
    private ArrayList<BankAccount> accounts;

    public AccountHolder(String name, String email, ArrayList<BankAccount> accounts) {
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }


    public void addAccount(BankAccount account) {
        accounts.add(account);
    }


    public BankAccount getAccountByNumber(int accountNumber) {

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber)
                
                return account;
        
        }

        return null;

    }

    public void listAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }


}