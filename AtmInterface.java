import java.util.Scanner;

class BankAccount {
    private double accountBalance;

    public BankAccount(double initialBalance) {
        accountBalance = initialBalance;
    }

    public double checkBalance() {
        return accountBalance;
    }

    public void depositFunds(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdrawFunds(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner userInput;

    public ATM(BankAccount account) {
        userAccount = account;
        userInput = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + userAccount.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = userInput.nextDouble();
                    userAccount.depositFunds(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = userInput.nextDouble();
                    userAccount.withdrawFunds(withdrawalAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void close() {
        userInput.close();
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);  // Initial account balance
        ATM atmMachine = new ATM(userAccount);
        atmMachine.run();
        atmMachine.close();
    }
}
