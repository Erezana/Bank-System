import java.util.*;
public class Main {
        private static Bank bank;
        private static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
                bank =null;

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
}

