package Threads.HusbandWife;

import java.math.BigDecimal;

public class BankAccount {
    private int accNo;
    private BigDecimal balance;

    public BankAccount(int accNo, BigDecimal balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public synchronized void deposit(BigDecimal amount) {
        while (balance.doubleValue() >= 15000) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to deposit...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance.add(amount);
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Current Balance: " + balance);
        notifyAll(); // Notify waiting threads to check their conditions
    }

    public synchronized void withdraw(BigDecimal amount) {
        while (balance.doubleValue() < amount.doubleValue()) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to withdraw...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance.subtract(amount);
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current Balance: " + balance);
        notifyAll(); // Notify waiting threads to check their conditions
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
