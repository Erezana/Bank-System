public class Main {
        public static void main(String[] args) {
                // Create a bank instance
                Bank bank = new Bank("MyBank", 10.0, 5.0);
                int accountId = 12345; // Sample account ID
                String userName = "Example"; // Sample username
                bank.createAccount(accountId, userName);
        }
}

