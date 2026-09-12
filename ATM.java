import java.util.Scanner;

public class ATM {

    private Scanner scanner;
    private BankAccount account;
    private int pin;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Set PIN
    private void setPin() {

        while (true) {

            System.out.print("Set your 4-digit PIN: ");
            int newPin = scanner.nextInt();

            if (newPin >= 1000 && newPin <= 9999) {

                pin = newPin;

                System.out.println("PIN set successfully!");
                break;

            } else {

                System.out.println(
                        "Invalid PIN! Please enter exactly 4 digits."
                );
            }
        }
    }

    // PIN before every transaction
    private boolean verifyPin() {

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {

            System.out.println("PIN verified successfully!");
            return true;

        } else {

            System.out.println("Wrong PIN!");
            System.out.println("Transaction cancelled.");

            return false;
        }
    }

    // Display ATM menu
    private void showMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("              ATM MENU");
        System.out.println("======================================");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println("======================================");
    }

    // Check balance
    private void checkBalance() {

        System.out.println();
        System.out.println("---------- CHECK BALANCE ----------");

        // PIN required
        if (!verifyPin()) {
            return;
        }

        System.out.println();
        System.out.printf(
                "Current Balance: Rs. %.2f%n",
                account.getBalance()
        );
    }

    // Withdraw money
    private void withdrawMoney() {

        System.out.println();
        System.out.println("---------- WITHDRAW MONEY ----------");

        // PIN required
        if (!verifyPin()) {
            return;
        }

        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {

            System.out.println(
                    "Invalid amount! Please enter a positive amount."
            );

            return;
        }

        if (amount > account.getBalance()) {

            System.out.println("Transaction failed!");
            System.out.println("Insufficient balance.");

            System.out.printf(
                    "Available Balance: Rs. %.2f%n",
                    account.getBalance()
            );

            return;
        }

        account.withdraw(amount);

        System.out.println();
        System.out.println("Withdrawal successful!");

        System.out.printf(
                "Amount Withdrawn: Rs. %.2f%n",
                amount
        );

        System.out.printf(
                "Remaining Balance: Rs. %.2f%n",
                account.getBalance()
        );
    }

    // Deposit money
    private void depositMoney() {

        System.out.println();
        System.out.println("---------- DEPOSIT MONEY ----------");

        // PIN required
        if (!verifyPin()) {
            return;
        }

        System.out.print("Enter amount to deposit: Rs. ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {

            System.out.println(
                    "Invalid amount! Please enter a positive amount."
            );

            return;
        }

        account.deposit(amount);

        System.out.println();
        System.out.println("Deposit successful!");

        System.out.printf(
                "Amount Deposited: Rs. %.2f%n",
                amount
        );

        System.out.printf(
                "New Balance: Rs. %.2f%n",
                account.getBalance()
        );
    }

    public void start() {

        System.out.println("======================================");
        System.out.println("          WELCOME TO JAVA ATM");
        System.out.println("======================================");

        setPin();

        System.out.println();
        System.out.println("ATM is now ready to use.");

        int choice;

        do {

            // Show menu
            showMenu();

            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("======================================");
                    System.out.println("      Thank you for using Java ATM!");
                    System.out.println("======================================");
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid option! Please select 1-4."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000.00);

        ATM atm = new ATM(account);
        atm.start();
    }
}