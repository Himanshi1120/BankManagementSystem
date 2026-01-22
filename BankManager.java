import java.io.*;
import java.util.HashMap;

public class BankManager {
    private HashMap<String, BankAccount> accountMap;
    private final String dataFilePath = "bankData.dat";

    public BankManager() {
        accountMap = new HashMap<>();
        loadData();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accountMap.put(accountNumber, account);
        saveData();
    }

    public BankAccount getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(dataFilePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountMap);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void loadData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dataFilePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            accountMap = (HashMap<String, BankAccount>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            accountMap = new HashMap<>();
        }
    }
}
