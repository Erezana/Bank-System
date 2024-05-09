import java.util.*;
public class Bank {
    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue){
        this.bankName = bankName;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
        this.accounts = new ArrayList<>();
        this.totalTransactionFeeAmount = 0.0;
        this.totalTransferAmount = 0.0;
    }
    public void createAccount(int accountId, String userName){
        if (String.valueOf(accountId).length() != 4) {
            System.out.println("Account ID must be a 4-digit number.");
            return;
        }
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                System.out.println("Account with ID " + accountId + " already exists. Please choose a different ID.");
                return;
            }
        }
        Account account = new Account(accountId, userName);
        accounts.add(account);
        System.out.println("Account created successfully");
    }
    public Account getAccount(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null; // Account not found
    }
    public void transferWithFlatFee(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount + transactionFlatFeeAmount); // Apply flat fee
            toAccount.deposit(amount);
            totalTransferAmount += amount;
            totalTransactionFeeAmount += transactionFlatFeeAmount;
            // Add transaction to history with correct originating and resulting account IDs
            fromAccount.getTransactionHistory().add(new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer with flat fee"));
            toAccount.getTransactionHistory().add(new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer with flat fee"));
            System.out.println("Transaction successful with flat fee.");
        } else {
            System.out.println("Insufficient funds for transaction.");
        }
    }
    public void transferWithPercentageFee(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            double fee = (transactionPercentFeeValue / 100) * amount; // Calculate percentage fee
            fromAccount.withdraw(amount + fee); // Apply percentage fee
            toAccount.deposit(amount);
            totalTransferAmount += amount;
            totalTransactionFeeAmount += fee;
            // Add transaction to history with correct originating and resulting account IDs
            fromAccount.getTransactionHistory().add(new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer with percentage fee"));
            toAccount.getTransactionHistory().add(new Transaction(amount, fromAccount.getAccountId(), toAccount.getAccountId(), "Transfer with percentage fee"));
            System.out.println("Transaction successful with percentage fee.");
        } else {
            System.out.println("Insufficient funds for transaction.");
        }
    }



}
