
Bank Management System
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

This project is a Java application designed to manage banking operations such as account creation, deposits, withdrawals, transfers, and transaction history tracking. It provides a simple interface for users to interact with the bank's functionalities.

Usage:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
- The Bank Management System offers the following functionalities:
- Create Bank: Allows users to create a new bank with specified transaction fees.
- Open Account: Enables the creation of new accounts within the bank.
- Deposit: Allows users to deposit funds into their accounts.
- Withdraw: Enables users to withdraw funds from their accounts.
- Transfer: Allows users to transfer funds between accounts.
- Display Transactions: Displays transaction history for a specified account.
- Check Account Balance: Displays the current balance for a specified account.
- Check Bank Accounts: Displays a list of accounts in the bank along with their details and transaction history.

How to Start the Application
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
To start the Bank Management System application, follow these steps:
- Run the Main Method:
   Execute the main method of the application. This will launch the application and display a menu with 9 options in the console.
- Choose an Option:
  After the menu is displayed, you'll be prompted to choose a number corresponding to the service you want to perform.
  Options range from creating a bank, opening an account, depositing funds, withdrawing funds, transferring funds, displaying transactions, checking account balances, viewing the list of 
  bank accounts, and exiting the program.
- Create a Bank:
  Before performing any banking services, you must create a bank by selecting the appropriate option from the menu.
  Enter the bank name, transaction flat fee amount, and transaction percent fee value when prompted.
- Open an Account:
  Once the bank is created, you can open an account by selecting the respective option from the menu.
  Enter the account ID and user name when prompted.
- Perform Banking Services:
  With the bank and account created, you can now perform various banking services such as depositing, withdrawing, transferring funds, and checking account details.
  Note that certain services, such as deposit, withdrawal, and transaction history display, require a valid account ID. Ensure that you have created an account before attempting these 
  services.
- Exit the Program:
To exit the program, select the "Exit" option from the menu.

Structure:
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
This project has four classes: Account, Transaction, Bank and Main class.

- Account Class:
Has the required attributes, such as account ID, user name, balance, and transaction history. This class provides methods to deposit funds, withdraw funds, get the current balance, and retrieve transaction history. It is responsible for managing individual accounts and their associated transactions.

- Transaction Class:
The Transaction class represents a financial transaction within the banking system. It has attributes such as transaction amount, originating account ID, resulting account ID, and transaction reason. This class provides a method to format transaction details as a string. It is used by the Account class to record and track individual transactions for each account.

- Bank Class"
This class provides methods to create a new bank, open accounts, perform transactions, display account details, and manage transaction fees. 

- Main Class"
This class provides a command-line interface for users to interact with the system's functionalities, such as creating a bank, opening accounts, performing transactions, and checking account details.





