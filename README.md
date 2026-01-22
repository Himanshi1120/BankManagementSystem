# Bank Management System

A simple yet functional bank management system built in Java that allows users to create accounts, perform transactions, and manage their finances.

## Features

- **Create Account**: Open a new bank account with initial balance
- **Deposit**: Add funds to your account
- **Withdraw**: Withdraw money from your account
- **Transfer**: Transfer funds between accounts
- **Check Balance**: View current account balance
- **Transaction History**: View all transactions for an account
- **Data Persistence**: Automatically saves and loads data using serialization

## Project Structure


BankManagementSystem/
├── BankAccount.java      # Represents individual bank accounts
├── BankManager.java      # Manages all accounts and data operations
├── Transaction.java      # Records transaction details
├── Main.java             # User interface and menu system
└── README.md             # Project documentation


## Class Descriptions

### BankAccount.java
- Stores account information (account number, holder name, balance)
- Maintains transaction history
- Implements `Serializable` for data persistence
- Methods: `deposit()`, `withdraw()`, `transfer()`, `getBalance()`, etc.

### BankManager.java
- Manages a HashMap of all bank accounts
- Handles data persistence (save/load operations)
- Uses file serialization (`bankData.dat`) to store account data
- Methods: `createAccount()`, `getAccount()`, `saveData()`, `loadData()`

### Transaction.java
- Records transaction information
- Stores: transaction type, amount, balance after transaction, and timestamp
- Implements `Serializable` for persistence
- Auto-formats timestamps as "dd-MM-yyyy HH:mm:ss"

### Main.java
- Provides interactive menu-driven user interface
- Handles user input and calls appropriate methods
- Menu options: Create Account, Deposit, Withdraw, Transfer, Check Balance, Transaction History, Exit

## How to Run

1. Compile all Java files:
   
   javac *.java
   

2. Run the program:
   
   java Main
   

3. Follow the on-screen menu to perform operations

## Usage Example

----- Bank System -----
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. Check Balance
6. Transaction History
7. Exit
Choose option: 1
Enter account number: ACC001
Enter account holder name: John Doe
Enter initial balance: 5000

## Data Storage

- Account data is automatically saved to `bankData.dat` after each operation
- Data is loaded from the file when the program starts
- Uses Java serialization for secure and efficient data storage

## Requirements

- Java 8 or higher
- No external dependencies

## Notes

- Each account must have a unique account number
- Minimum balance requirements can be implemented if needed
- Transaction history is maintained for audit purposes
