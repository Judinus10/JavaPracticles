package Threads.couresWork.Scenario_2;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionSystem {
    private final Map<Integer, BankAccount> accounts = new ConcurrentHashMap<>();

    public TransactionSystem() {}

    public void addAccount(BankAccount account) {
        accounts.put(account.getId(), account);
    }

    public void transfer(int fromAccountId, int toAccountId, BigDecimal amount) {
        BankAccount fromAccount = accounts.get(fromAccountId);
        BankAccount toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID(s).");
        }

        try {
            fromAccount.transfer(toAccount, amount);
        } catch (InsufficientBalanceException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }

    public void reverseTransaction(int fromAccountId, int toAccountId, BigDecimal amount) {
        BankAccount fromAccount = accounts.get(fromAccountId);
        BankAccount toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID(s).");
        }

        try {
            // Reverse the transfer by doing the opposite operation
            toAccount.withdraw(amount);
            fromAccount.deposit(amount);
            System.out.println("Transaction reversed: " + amount + " has been returned to Account " + fromAccountId);
        } catch (InsufficientBalanceException e) {
            System.err.println("Reverse transaction failed: " + e.getMessage());
        }
    }

    public void printAccountBalances() {
        accounts.forEach((id, account) ->
                System.out.println("Account ID: " + id + ", Balance: " + account.getBalance())
        );
    }
}

