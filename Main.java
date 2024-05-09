import java.util.*;
public class Main {
        private static Bank bank;
        private static Scanner scanner = new Scanner(System.in);


        public static void main(String[] args) {
                bank =null;
                printMenu();
                boolean exit = false;

                while (!exit) {
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                                case 1:
                                        createBank();
                                        break;
                                case 2:
                                        openAccount();
                                        break;
                                case 3:
                                        deposit();
                                        break;
                                case 4:
                                        withdraw();
                                        break;
                        }
                }


        }
        private static void printMenu(){
                System.out.println("Welcome");
                System.out.println("1. Create a bank");
                System.out.println("2. Open Account");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Transfer");
                System.out.println("6. Display transactions");
                System.out.println("7. Check account balance");
                System.out.println("8. Check accounts in this bank");
                System.out.println("0. Exit");

        }
        private static void createBank(){
                System.out.println("Creating a new bank...");
                System.out.print("Enter bank name: ");
                String bankName = scanner.nextLine(); // Consume newline character

                System.out.print("Enter transaction flat fee amount: ");
                double flatFeeAmount = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter transaction percent fee value: ");
                double percentFeeValue = Double.parseDouble(scanner.nextLine());

                bank = new Bank(bankName, flatFeeAmount, percentFeeValue);
                System.out.println("Bank created successfully.");

        }
        private static void openAccount(){
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                System.out.print("Enter user name: ");
                String userName = scanner.next();
                bank.createAccount(accountId, userName);
        }
        private static void deposit(){
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                Account account = bank.getAccount(accountId);
                if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                        System.out.println("Deposit successful. New balance: $" + account.getBalance() +"with account ID" + accountId);
                } else {
                        System.out.println("Account not found.");
                }

        }
        private static void withdraw() {
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                Account account = bank.getAccount(accountId);
                if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        if (account.getBalance() >= amount) {
                                account.withdraw(amount);
                                System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                        } else {
                                System.out.println("Not enough funds.");
                        }
                } else {
                        System.out.println("Account not found.");
                }
        }



}

