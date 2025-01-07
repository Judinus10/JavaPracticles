package Threads.couresWork.Scenario_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    // ReentrantReadWriteLock used to allow multiple readers or one writer, with a fair policy for thread acquisition
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
    private final Lock readLock = rwl.readLock();
    private final Lock writeLock = rwl.writeLock();

    private BigDecimal balance;
    private final int id; // Account ID (changed to int)
    private final List<String> transactionHistory = new CopyOnWriteArrayList<>(); // Thread-safe transaction history

    // Constructor to initialize the bank account with an ID and balance
    public BankAccount(int id, BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = balance;
        this.id = id;
    }

    // Method to deposit an amount into the account
    public void deposit(BigDecimal amount) {
        writeLock.lock(); // Lock for writing
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                this.balance = balance.add(amount);
                transactionHistory.add("Deposited: " + amount + ", Balance: " + this.balance);
                System.out.println(Thread.currentThread().getName() + " - Deposit successful! Balance: " + this.balance);
            } else {
                throw new IllegalArgumentException("Deposit amount must be greater than zero.");
            }
        } finally {
            writeLock.unlock(); // Unlock after transaction
        }
    }

    // Method to withdraw an amount from the account
    public void withdraw(BigDecimal amount) {
        writeLock.lock(); // Lock for writing
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0 && this.balance.compareTo(amount) >= 0) {
                this.balance = balance.subtract(amount);
                transactionHistory.add("Withdrawn: " + amount + ", Balance: " + this.balance);
                System.out.println(Thread.currentThread().getName() + " - Withdraw successful! Balance: " + this.balance);
            } else {
                throw new InsufficientBalanceException("Insufficient balance for withdrawal.", id, amount.doubleValue());
            }
        } finally {
            writeLock.unlock(); // Unlock after transaction
        }
    }

    // Method to get the current balance of the account
    public BigDecimal getBalance() {
        readLock.lock(); // Lock for reading
        try {
            return balance;
        } finally {
            readLock.unlock(); // Unlock after reading
        }
    }

    // Method to get the account ID
    public int getId() { // Changed to return int
        return id;
    }

    // Method to get a snapshot of the transaction history
    public List<String> getTransactionHistory() {
        readLock.lock(); // Lock for reading
        try {
            return new ArrayList<>(transactionHistory); // Return a copy of the transaction history
        } finally {
            readLock.unlock(); // Unlock after reading
        }
    }

    // Method to transfer money between two bank accounts
    public void transfer(BankAccount toAccount, BigDecimal amount) {
        // Lock accounts in a consistent order to avoid deadlock
        BankAccount firstLock = this.id > toAccount.id ? this : toAccount;
        BankAccount secondLock = this.id > toAccount.id ? toAccount : this;

        firstLock.writeLock.lock(); // Lock the first account for writing
        secondLock.writeLock.lock(); // Lock the second account for writing

        try {
            this.withdraw(amount); // Withdraw from the source account
            toAccount.deposit(amount); // Deposit into the destination account
            transactionHistory.add("Transferred: " + amount + " to " + toAccount.id);
            System.out.println(Thread.currentThread().getName() + " - Transfer successful: " + amount);
        } finally {
            secondLock.writeLock.unlock(); // Unlock the second account after the transfer
            firstLock.writeLock.unlock(); // Unlock the first account after the transfer
        }
    }

    // New method to lock the account for writing (custom locking mechanism)
    public void lock() {
        writeLock.lock(); // Lock the account for writing
        System.out.println(Thread.currentThread().getName() + " - Account locked.");
    }

    // New method to unlock the account after performing actions
    public void unlock() {
        writeLock.unlock(); // Unlock the account after the actions
        System.out.println(Thread.currentThread().getName() + " - Account unlocked.");
    }
}
