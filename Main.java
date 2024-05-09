import java.util.*;
public class Main {
        private static Bank bank;
        private static Scanner scanner = new Scanner(System.in);


        public static void main(String[] args) {
                bank =null;
                boolean exit = false;
                printMenu();


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
                                case 5:
                                        transfer();
                                        break;
                                case 6:
                                        viewTransactionHistory();
                                        break;
                                case 7:
                                        checkAccountBalance();
                                        break;
                                case 8:
                                        seeListOfBankAccounts();
                                        break;
                                case 0:
                                        System.out.println("Exiting program. Goodbye!");
                                        exit = true;
                                default:
                                        System.out.println("Invalid choice. Please enter a valid option.");
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
        private static void transfer() {
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }
                System.out.print("Enter sender account ID: ");
                int fromAccountId = scanner.nextInt();
                Account fromAccount = bank.getAccount(fromAccountId);
                if (fromAccount == null) {
                        System.out.println("Sender account not found.");
                        return;
                }

                System.out.print("Enter recipient account ID: ");
                int toAccountId = scanner.nextInt();
                Account toAccount = bank.getAccount(toAccountId);
                if (toAccount == null) {
                        System.out.println("Recipient account not found.");
                        return;
                }

                System.out.print("Enter transfer amount: ");
                double amount = scanner.nextDouble();

                System.out.print("Enter transaction type (1 for flat fee, 2 for percentage fee): ");
                int transactionType = scanner.nextInt();

                if (transactionType == 1) {
                        bank.transferWithFlatFee(fromAccount, toAccount, amount);
                } else if (transactionType == 2) {
                        bank.transferWithPercentageFee(fromAccount, toAccount, amount);
                } else {
                        System.out.println("Invalid transaction type.");
                }
        }
        private static void viewTransactionHistory() {
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }

                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                Account account = bank.getAccount(accountId);

                if (account != null) {
                        bank.displayAccountTransactions(account);
                } else {
                        System.out.println("Account not found.");
                }
        }
        private static void checkAccountBalance() {
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }

                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();

                Account account = bank.getAccount(accountId);
                if (account != null) {
                        double balance = account.getBalance();
                        System.out.println("Account balance for account ID " + accountId + ": $" + balance);
                } else {
                        System.out.println("Account not found.");
                }
        }
        private static void seeListOfBankAccounts() {
                if (bank == null) {
                        System.out.println("Please create a bank first.");
                        return;
                }

                bank.displayBankAccounts();
        }



}

