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
        Account account = new Account(accountId, userName);
        accounts.add(account);
        System.out.println("Account created successfully");
    }



}
