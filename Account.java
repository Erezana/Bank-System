import java.util.List;

public class Account {
    private int accountId;
    private String userName;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(int accountId, String userName) {
        this.accountId= accountId;
        this.userName=userName;
        this.balance=0.0;
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
    }

    public void deposit(double amount){
        balance+=amount;

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
