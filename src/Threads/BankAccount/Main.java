package Threads.BankAccount;

import java.math.BigDecimal;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(BigDecimal.valueOf(10000), "AC001");
        BankAccount bankAccount2 = new BankAccount(BigDecimal.valueOf(5000), "AC002");
        BankAccount bankAccount3 = new BankAccount(BigDecimal.valueOf(15000), "AC003");

        Random random = new Random();

        // Thread 1: Transfer from account 1 to account 2
        Thread t1 = new Thread(() -> {
            try {
                BigDecimal amount = BigDecimal.valueOf((random.nextInt(5) + 1) * 1000);
                bankAccount1.transfer(bankAccount2, amount);
                System.out.println("Thread 1: Transferred " + amount + " from Account AC001 to AC002");
            } catch (Exception e) {
                System.out.println("Thread 1: " + e.getMessage());
            }
        }, "Transfer from Account 1 to Account 2");

        // Thread 2: Transfer from account 2 to account 3
        Thread t2 = new Thread(() -> {
            try {
                BigDecimal amount = BigDecimal.valueOf((random.nextInt(5) + 1) * 1000);
                bankAccount2.transfer(bankAccount3, amount);
                System.out.println("Thread 2: Transferred " + amount + " from Account AC002 to AC003");
            } catch (Exception e) {
                System.out.println("Thread 2: " + e.getMessage());
            }
        }, "Transfer from Account 2 to Account 3");

        // Thread 3: Deposit into account 1
        Thread t3 = new Thread(() -> {
            try {
                BigDecimal amount = BigDecimal.valueOf((random.nextInt(5) + 1) * 1000);
                bankAccount1.deposit(amount);
                System.out.println("Thread 3: Deposited " + amount + " into Account AC001");
            } catch (Exception e) {
                System.out.println("Thread 3: " + e.getMessage());
            }
        }, "Deposit into Account 1");

        // Thread 4: Withdraw from account 3
        Thread t4 = new Thread(() -> {
            try {
                BigDecimal amount = BigDecimal.valueOf((random.nextInt(5) + 1) * 1000);
                bankAccount3.withdraw(amount);
                System.out.println("Thread 4: Withdrew " + amount + " from Account AC003");
            } catch (Exception e) {
                System.out.println("Thread 4: " + e.getMessage());
            }
        }, "Withdraw from Account 3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        // Print final balances and transaction histories
        System.out.println("\nFinal Balances:");
        System.out.println("Account AC001: " + bankAccount1.getBalance());
        System.out.println("Account AC002: " + bankAccount2.getBalance());
        System.out.println("Account AC003: " + bankAccount3.getBalance());

        System.out.println("\nTransaction Histories:");
        System.out.println("Account AC001: " + bankAccount1.getTransactionHistory());
        System.out.println("Account AC002: " + bankAccount2.getTransactionHistory());
        System.out.println("Account AC003: " + bankAccount3.getTransactionHistory());
    }
}
