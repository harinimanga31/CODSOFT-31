import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Your balance is: $" + balance);
            return false;
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
            return false;
        }
    }
    public double getBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please select a valid choice.");
            }
        }
    }
    private void performWithdrawal() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
    private void performDeposit() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }
    private void checkBalance() {
        System.out.println("Your current balance is: $" + userAccount.getBalance());
    }
}
public class ATMSimulation {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00); 
        ATM atm = new ATM(userAccount);
        atm.displayMenu(); 
    }
}
