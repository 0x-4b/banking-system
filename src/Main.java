import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main class for the banking system.
 * Handles user interaction, account creation, deposits, withdrawals, and account info display.
 */
public class Main {
    // Shared scanner for user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int accountNumber = 1001; // Starting account number

        // List to store all bank accounts for the user
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        // Gather user details
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();
        System.out.println();
        System.out.println("Welcome " + userName + ".");

        // Create an AccountHolder object for the user
        AccountHolder user = new AccountHolder(userName, userEmail, accounts);

        // Main menu loop
        while (true) {
            BankAccount account;
            System.out.println("1. Create account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account info");
            System.out.println("5. EXIT");

            System.out.print("Choose: ");
            int userChoice = -1;
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (userChoice) {
                case 1:
                    // Account creation
                    System.out.print("Choose account type (Savings / Checking): ");
                    String accountChoice = scanner.nextLine();

                    if (accountChoice.equals("Savings")) {
                        System.out.print("Enter the interest rate: ");
                        double interestRate = scanner.nextDouble();
                        accounts.add(new SavingsAccount(accountNumber, 0, interestRate));
                        System.out.println("Successfully opened a " + accountChoice + " account. Account number: " + accountNumber);
                        accountNumber++;
                    } else if (accountChoice.equals("Checking")) {
                        System.out.print("Enter the overdraft limit: ");
                        double overdraftLimit = scanner.nextDouble();
                        accounts.add(new CheckingAccount(accountNumber, 0, overdraftLimit));
                        System.out.println("Successfully opened a " + accountChoice + " account. Account number: " + accountNumber);
                        accountNumber++;
                    } else {
                        System.out.println("Choose a valid account type.");
                    }
                    break;

                case 2:
                    // Deposit money
                    account = checkForAccount(user);
                    if (account != null) {
                        System.out.print("Enter the amount to be deposited: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Withdraw money
                    account = checkForAccount(user);
                    if (account != null) {
                        System.out.print("Enter the amount to be withdrawn: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // View account info
                    account = checkForAccount(user);
                    if (account != null) {
                        System.out.println(account.toString());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Thanks for banking with us. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Something went wrong.");
                    break;
            }
        }
    }

    /**
     * Prompts the user for an account number and returns the corresponding BankAccount object.
     * @param user the AccountHolder whose accounts are searched
     * @return the BankAccount if found, otherwise null
     */
    public static BankAccount checkForAccount(AccountHolder user) {
        System.out.print("Enter account number: ");
        int accountNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount account = user.getAccountByNumber(accountNum);
        return account;
    }
}
