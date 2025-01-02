package Threads.couresWork.Scenario_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true); // Fair policy
    private final Lock readLock = rwl.readLock();
    private final Lock writeLock = rwl.writeLock();
    private BigDecimal balance;
    private final int id; // Changed to int
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(int id, BigDecimal balance) { // Constructor updated to accept int
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = balance;
        this.id = id;
    }

    public void deposit(BigDecimal amount) {
        writeLock.lock();
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                this.balance = balance.add(amount);
                transactionHistory.add("Deposited: " + amount + ", Balance: " + this.balance);
                System.out.println(Thread.currentThread().getName() + " - Deposit successful! Balance: " + this.balance);
            } else {
                throw new IllegalArgumentException("Deposit amount must be greater than zero.");
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) {
        writeLock.lock();
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0 && this.balance.compareTo(amount) >= 0) {
                this.balance = balance.subtract(amount);
                transactionHistory.add("Withdrawn: " + amount + ", Balance: " + this.balance);
                System.out.println(Thread.currentThread().getName() + " - Withdraw successful! Balance: " + this.balance);
            } else {
                throw new InsufficientBalanceException("Insufficient balance for withdrawal.", id, amount.doubleValue());
            }
        } finally {
            writeLock.unlock();
        }
    }

    public BigDecimal getBalance() {
        readLock.lock();
        try {
            return balance;
        } finally {
            readLock.unlock();
        }
    }

    public int getId() { // Changed to return int
        return id;
    }

    public List<String> getTransactionHistory() {
        readLock.lock();
        try {
            return new ArrayList<>(transactionHistory);
        } finally {
            readLock.unlock();
        }
    }

    public void transfer(BankAccount toAccount, BigDecimal amount) {
        BankAccount firstLock = this.id > toAccount.id ? this : toAccount;
        BankAccount secondLock = this.id > toAccount.id ? toAccount : this;

        firstLock.writeLock.lock();
        secondLock.writeLock.lock();

        try {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + toAccount.id);
            System.out.println(Thread.currentThread().getName() + " - Transfer successful: " + amount);
        } finally {
            secondLock.writeLock.unlock();
            firstLock.writeLock.unlock();
        }
    }

    // New lock method
    public void lock() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + " - Account locked.");
    }

    // New unlock method
    public void unlock() {
        writeLock.unlock();
        System.out.println(Thread.currentThread().getName() + " - Account unlocked.");
    }
}
