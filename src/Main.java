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
            System.out.println("\n1. Create account");
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
                    accountNumber = createAccount(user, accountNumber);
                    break;
                case 2:
                    depositToAccount(user);
                    break;
                case 3:
                    withdrawFromAccount(user);
                    break;
                case 4:
                    viewAccountInfo(user);
                    break;
                case 5:
                    System.out.println("Thanks for banking with us. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a valid option (1-5).");
                    break;
            }
        }
    }

    /**
     * Handles account creation with improved input validation.
     * @param user the AccountHolder
     * @param accountNumber the current account number
     * @return the next account number to use
     */
    public static int createAccount(AccountHolder user, int accountNumber) {
        while (true) {
            System.out.print("Choose account type (Savings / Checking): ");
            String accountChoice = scanner.nextLine().trim();

            if (accountChoice.equalsIgnoreCase("Savings")) {
                double interestRate = -1;
                while (interestRate < 0) {
                    System.out.print("Enter the interest rate (as a decimal, e.g., 0.03 for 3%): ");
                    try {
                        interestRate = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (interestRate < 0) {
                            System.out.println("Interest rate cannot be negative.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the interest rate.");
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                user.addAccount(new SavingsAccount(accountNumber, 0, interestRate));
                System.out.println("Successfully opened a Savings account. Account number: " + accountNumber);
                return accountNumber + 1;
            } else if (accountChoice.equalsIgnoreCase("Checking")) {
                double overdraftLimit = -1;
                while (overdraftLimit < 0) {
                    System.out.print("Enter the overdraft limit: ");
                    try {
                        overdraftLimit = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (overdraftLimit < 0) {
                            System.out.println("Overdraft limit cannot be negative.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the overdraft limit.");
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                user.addAccount(new CheckingAccount(accountNumber, 0, overdraftLimit));
                System.out.println("Successfully opened a Checking account. Account number: " + accountNumber);
                return accountNumber + 1;
            } else {
                System.out.println("Invalid account type. Please enter 'Savings' or 'Checking'.");
            }
        }
    }

    /**
     * Handles depositing money into an account with input validation.
     * @param user the AccountHolder
     */
    public static void depositToAccount(AccountHolder user) {
        BankAccount account = checkForAccount(user);
        if (account != null) {
            double depositAmount = -1;
            while (depositAmount <= 0) {
                System.out.print("Enter the amount to be deposited: ");
                try {
                    depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (depositAmount <= 0) {
                        System.out.println("Please enter a positive amount.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            account.deposit(depositAmount);
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Handles withdrawing money from an account with input validation.
     * @param user the AccountHolder
     */
    public static void withdrawFromAccount(AccountHolder user) {
        BankAccount account = checkForAccount(user);
        if (account != null) {
            double withdrawAmount = -1;
            while (withdrawAmount <= 0) {
                System.out.print("Enter the amount to be withdrawn: ");
                try {
                    withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (withdrawAmount <= 0) {
                        System.out.println("Please enter a positive amount.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            account.withdraw(withdrawAmount);
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Handles displaying account information.
     * @param user the AccountHolder
     */
    public static void viewAccountInfo(AccountHolder user) {
        BankAccount account = checkForAccount(user);
        if (account != null) {
            System.out.println(account.toString());
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Prompts the user for an account number and returns the corresponding BankAccount object.
     * @param user the AccountHolder whose accounts are searched
     * @return the BankAccount if found, otherwise null
     */
    public static BankAccount checkForAccount(AccountHolder user) {
        System.out.print("Enter account number: ");
        int accountNum = -1;
        try {
            accountNum = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid account number.");
            scanner.nextLine(); // Clear invalid input
            return null;
        }
        return user.getAccountByNumber(accountNum);
    }
}
