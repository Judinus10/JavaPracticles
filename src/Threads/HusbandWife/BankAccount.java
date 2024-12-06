package Threads.HusbandWife;

import java.math.BigDecimal;

public class BankAccount {
    private int accNo;
    private BigDecimal balance;

    public BankAccount(int accNo, BigDecimal balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public synchronized BigDecimal getBalance() {
        return balance;
    }

    public synchronized void deposit(BigDecimal amount) {
        while (balance.doubleValue() >= 15000) { // Wait if balance is sufficient
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance.add(amount);
//        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", New Balance: " + balance);
        notifyAll(); // Notify waiting threads
    }

    public synchronized void withdraw(BigDecimal amount) {
        while (balance.doubleValue() < amount.doubleValue()) { // Wait if insufficient balance
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance.subtract(amount);
//        System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", New Balance: " + balance);
        notifyAll(); // Notify waiting threads
    }
}
