import java.util.*;

public class Account {
    private int accountId;
    private String userName;
    private double balance;
    private List<Transaction> transactionHistory;
    public Account(int accountId, String userName) {
        this.accountId= accountId;
        this.userName=userName;
        this.balance=0.0;
        this.transactionHistory = new ArrayList<>();
    }
    public void withdraw(double amount){
        if(amount<=0) {
            System.out.println("Invalid amount for withdrawal.");
            return;
        }
        if(amount>balance){
            System.out.println("Not enough funds");
            return;
        }
        balance -=amount;
        transactionHistory.add(new Transaction(amount, accountId, accountId, "Withdrawal"));
    }

    public void deposit(double amount){
        balance+=amount;
        transactionHistory.add(new Transaction(amount, accountId, accountId, "Deposit"));
    }
    public double getBalance() {
        return balance;
    }
    public int getAccountId() {
        return accountId;
    }
    public String getUserName() {
        return userName;
    }
    public List<Transaction> getTransactionHistory()
    {
        return transactionHistory;
    }
}
