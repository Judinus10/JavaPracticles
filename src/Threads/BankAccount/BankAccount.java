package Threads.BankAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.math.BigDecimal;

// Custom exception for insufficient balance
class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {
    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock(true); // Fair lock
    private Lock readLock = rw1.readLock();
    private Lock writeLock = rw1.writeLock();
    private BigDecimal balance;
    private String accountId;
    private List<String> transactionHistory = new ArrayList<>();

    public BankAccount(BigDecimal balance, String accountId) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountId = accountId;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        writeLock.lock();
        try {
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                this.balance = this.balance.add(amount);
                System.out.println(Thread.currentThread().getName() + " Deposit successful");
                transactionHistory.add("Account ID: " + this.accountId + " deposit successful, Amount: " + amount);
            } else {
                throw new IllegalArgumentException("Deposit amount must be greater than 0");
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) {
        writeLock.lock();
        try {
            if (amount.compareTo(this.balance) <= 0) {
                this.balance = this.balance.subtract(amount);
                System.out.println(Thread.currentThread().getName() + " Withdraw successful, Account ID: " + this.accountId);
                transactionHistory.add("Account ID: " + this.accountId + " withdraw successful, Amount: " + amount);
            } else {
                try {
                    throw new insufficientBalanceException("Insufficient funds to withdraw");
                } catch (insufficientBalanceException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            writeLock.unlock();
        }
    }

    public double getBalance() {
        readLock.lock();
        try {
            return this.balance.doubleValue();
        } finally {
            readLock.unlock();
        }
    }

    public List<String> getTransactionHistory() {
        readLock.lock();
        try {
            return Collections.unmodifiableList(transactionHistory);
        } finally {
            readLock.unlock();
        }
    }

    public void transfer(BankAccount toAccount, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than 0");
        }

        BankAccount firstLock = this.accountId.compareTo(toAccount.accountId) > 0 ? this : toAccount;
        BankAccount secondLock = firstLock == this ? toAccount : this;

        firstLock.writeLock.lock();
        secondLock.writeLock.lock();

        try {
            if (this.balance.compareTo(amount) >= 0) {
                this.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " Transfer successful from " + this.accountId + " to " + toAccount.accountId);
                transactionHistory.add("Transferred " + amount + " from Account ID: " + this.accountId + " to Account ID: " + toAccount.accountId);
            } else {
                try {
                    throw new insufficientBalanceException("Insufficient funds for transfer");
                } catch (insufficientBalanceException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            firstLock.writeLock.unlock();
            secondLock.writeLock.unlock();
        }
    }
}
