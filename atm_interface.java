//CODSOFT Task-3 ATM Interface
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: Rs." + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: Rs." + balance);
                return true; // Return true on successful withdrawal
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Invalid Amount! Please re-enter positive amount.");
        }
        return false; // Return false if withdrawal failed
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount; // Correct the constructor syntax
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: "); // Fixed to use print
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Current balance: Rs." + bankAccount.getBalance()); // Added Rs. to balance
                    break; // Add break statement to prevent fall-through
                }
                case 2: {
                    System.out.print("Enter the amount to deposit: "); // Fixed to use print
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break; // Add break statement
                }
                case 3: {
                    System.out.print("Enter the withdrawal amount: "); // Fixed to use print
                    double withdrawalAmount = scanner.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdrawalAmount);
                    if (withdrawSuccess) {
                        System.out.println("Withdraw successful");
                    }
                    break; // Add break statement
                }
                case 4: {
                    System.out.println("THANK YOU FOR USING THE ATM!");
                    scanner.close(); // Close scanner
                    return; // Exit the loop
                }
                default: {
                    System.out.println("Invalid Choice. Please try again!");
                    break; // Add break statement
                }
            }
        }
    }
}

public class atm_interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Corrected class name
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
