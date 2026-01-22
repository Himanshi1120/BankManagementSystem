import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactionList;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionList = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction("Deposit", amount, balance);
        transactionList.add(transaction);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        Transaction transaction = new Transaction("Withdraw", amount, balance);
        transactionList.add(transaction);
        return true;
    }

    public boolean transferTo(BankAccount receiver, double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        receiver.balance += amount;

        Transaction transaction = new Transaction("Transfer to " + receiver.accountNumber, amount, balance);
        transactionList.add(transaction);

        Transaction receiverTransaction = new Transaction("Transfer from " + accountNumber, amount, receiver.balance);
        receiver.transactionList.add(receiverTransaction);

        return true;
    }
}
