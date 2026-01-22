import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- U&ME Bank System -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter Account Holder Name: ");
                String holderName = scanner.nextLine();
                System.out.print("Enter Initial Balance: ");
                double initialBalance = scanner.nextDouble();
                scanner.nextLine();

                bankManager.createAccount(accountNumber, holderName, initialBalance);
                System.out.println("Account created successfully.");
            }

            else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bankManager.getAccount(accountNumber);

                if (account != null) {
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    account.deposit(amount);
                    bankManager.saveData();
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Account not found.");
                }
            }

            else if (choice == 3) {
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bankManager.getAccount(accountNumber);

                if (account != null) {
                    System.out.print("Enter Amount to Withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean success = account.withdraw(amount);
                    if (success) {
                        bankManager.saveData();
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            }

            else if (choice == 4) {
                System.out.print("Enter Sender Account Number: ");
                String senderNumber = scanner.nextLine();
                BankAccount sender = bankManager.getAccount(senderNumber);

                System.out.print("Enter Receiver Account Number: ");
                String receiverNumber = scanner.nextLine();
                BankAccount receiver = bankManager.getAccount(receiverNumber);

                if (sender != null && receiver != null) {
                    System.out.print("Enter Amount to Transfer: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean success = sender.transferTo(receiver, amount);
                    if (success) {
                        bankManager.saveData();
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            }

            else if (choice == 5) {
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bankManager.getAccount(accountNumber);

                if (account != null) {
                    System.out.println("Current Balance: " + account.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            }

            else if (choice == 6) {
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bankManager.getAccount(accountNumber);

                if (account != null) {
                    System.out.println("Transaction History:");
                    for (Transaction transaction : account.getTransactionList()) {
                        System.out.println(transaction);
                    }
                } else {
                    System.out.println("Account not found.");
                }
            }

            else if (choice == 7) {
                System.out.println("Thank you for using U&ME Bank System.");
                break;
            }

            else {
                System.out.println("Invalid option.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
