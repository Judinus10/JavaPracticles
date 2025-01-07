package Threads.couresWork.Scenario_2;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionSystem {
    // Use a ConcurrentHashMap to store accounts, ensuring thread-safety
    private final Map<Integer, BankAccount> accounts = new ConcurrentHashMap<>();

    // Constructor to initialize the TransactionSystem
    public TransactionSystem() {}

    // Method to add a bank account to the system
    public void addAccount(BankAccount account) {
        accounts.put(account.getId(), account);
    }

    // Method to transfer money from one account to another
    public void transfer(int fromAccountId, int toAccountId, BigDecimal amount) {
        // Retrieve the source and destination accounts
        BankAccount fromAccount = accounts.get(fromAccountId);
        BankAccount toAccount = accounts.get(toAccountId);

        // Validate account existence
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID(s).");
        }

        // Perform the transfer and handle any exceptions
        try {
            fromAccount.transfer(toAccount, amount);
        } catch (InsufficientBalanceException e) {
            // If there are insufficient funds in the source account
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }

    // Method to reverse a transaction (refund the amount to the source account)
    public void reverseTransaction(int fromAccountId, int toAccountId, BigDecimal amount) {
        // Retrieve the source and destination accounts
        BankAccount fromAccount = accounts.get(fromAccountId);
        BankAccount toAccount = accounts.get(toAccountId);

        // Validate account existence
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID(s).");
        }

        // Perform the reverse transaction and handle any exceptions
        try {
            toAccount.withdraw(amount); // Withdraw the amount from the destination account
            fromAccount.deposit(amount); // Deposit the amount back to the source account
            // Print a message and update the transaction history
            System.out.println("Transaction reversed: " + amount + " has been returned to Account " + fromAccountId);
            fromAccount.getTransactionHistory().add("Reversed: " + amount + " from " + toAccountId);
        } catch (InsufficientBalanceException e) {
            // If the destination account does not have sufficient funds to reverse the transaction
            System.err.println("Reverse transaction failed: " + e.getMessage());
        }
    }

    // Method to print the balances of all accounts in the system
    public void printAccountBalances() {
        // Loop through all accounts and print their details
        accounts.forEach((id, account) ->
                System.out.println("Account ID: " + id + ", Balance: " + account.getBalance())
        );
    }
}
