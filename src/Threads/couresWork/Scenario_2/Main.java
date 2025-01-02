package Threads.couresWork.Scenario_2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TransactionSystem ts = new TransactionSystem();

        BankAccount b1 = new BankAccount(001 , BigDecimal.valueOf(10000));
        BankAccount b2 = new BankAccount(002 , BigDecimal.valueOf(8000));
        BankAccount b3 = new BankAccount(003 , BigDecimal.valueOf(12000));

        ts.addAccount(b1);
        ts.addAccount(b2);
        ts.addAccount(b3);

        Thread t1 = new Thread(() -> ts.transfer(001, 002, BigDecimal.valueOf(2500)), "Thread 1");
        Thread t2 = new Thread(() -> ts.transfer(002, 003, BigDecimal.valueOf(3000)), "Thread 2");
        Thread t3 = new Thread(() -> ts.transfer(003, 001, BigDecimal.valueOf(2000)), "Thread 3");
        Thread t4 = new Thread(() -> ts.reverseTransaction(002, 003, BigDecimal.valueOf(3000)), "Thread 4");
        Thread t5 = new Thread(() -> ts.printAccountBalances(), "Thread 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
