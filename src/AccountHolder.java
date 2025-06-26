import java.util.ArrayList;

/**
 * Represents a person who holds one or more bank accounts.
 * Stores the holder's name, email, and a list of their bank accounts.
 */
public class AccountHolder {

    // The account holder's full name
    private String name;
    // The account holder's email address
    private String email;
    // List of all bank accounts owned by this holder
    private ArrayList<BankAccount> accounts;

    /**
     * Creates a new AccountHolder with the given name, email, and accounts.
     * @param name    the account holder's name
     * @param email   the account holder's email address
     * @param accounts the list of bank accounts (should not be null)
     */
    public AccountHolder(String name, String email, ArrayList<BankAccount> accounts) {
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }

    /**
     * Adds a new bank account to this holder's list of accounts.
     * @param account the BankAccount to add
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    /**
     * Finds and returns a bank account by its account number.
     * @param accountNumber the account number to search for
     * @return the BankAccount with the matching number, or null if not found
     */
    public BankAccount getAccountByNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            // Check if this account's number matches the search
            if (account.getAccountNumber() == accountNumber)
                return account;
        }
        // No account found with the given number
        return null;
    }

    /**
     * Prints all bank accounts owned by this account holder.
     * Each account is printed on a separate line.
     */
    public void listAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }


}