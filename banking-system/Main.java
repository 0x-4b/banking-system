import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int accountNumber = 1001;

        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();
        System.out.println();
        System.out.println("Welcome " + userName + ".");
        AccountHolder user = new AccountHolder(userName, userEmail, accounts);
        while (true) {

            BankAccount account;
            System.out.println("1. Create account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account info");
            System.out.println("5. EXIT");

            System.out.print("Choose: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Choose account type (Savings / Checking): ");
                    String accountChoice = scanner.nextLine();

                    if (accountChoice.equals("Savings")) {
                        System.out.print("Enter the interest rate: ");
                        double interestRate = scanner.nextDouble();
                        accounts.add(new SavingsAccount(accountNumber, 0, interestRate));

                        System.out.println("Successfully opened a " + accountChoice + " account. Account number: "
                                + accountNumber);
                        accountNumber++;
                    } else if (accountChoice.equals("Checking")) {
                        System.out.print("Enter the overdraft limit: ");
                        double overdraftLimit = scanner.nextDouble();
                        accounts.add(new CheckingAccount(accountNumber, 0, overdraftLimit));

                        System.out.println("Successfully opened a " + accountChoice + " account. Account number: "
                                + accountNumber);
                        accountNumber++;
                    } else {
                        System.out.println("Choose a valid account type.");
                    }
                    break;

                case 2:
                    account = checkForAccount(user);

                    if (account != null) {
                        System.out.print("Enter the amount to be deposited: ");
                        double depositAmount = scanner.nextInt();
                        account.deposit(depositAmount);
                    }

                    else {
                        System.out.println("Account not found.");
                    }

                    break;
                case 3:
                    account = checkForAccount(user);

                    if (account != null) {
                        System.out.print("Enter the amount to be withdrawn: ");
                        double withdrawAmount = scanner.nextInt();
                        account.withdraw(withdrawAmount);
                    }

                    else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 4:
                    account = checkForAccount(user);

                    if (account != null) {
                        System.out.println(account.toString());
                    }

                    else {
                        System.out.println("Account not found.");
                    }

                    break;
                case 5:
                    System.out.println("Thanks for banking with us. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Something went wrong.");
                    break;
            }
        }
    }

    public static BankAccount checkForAccount(AccountHolder user) {

        System.out.print("Enter account number: ");
        int accountNum = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = user.getAccountByNumber(accountNum);

        return account;
    }

}
