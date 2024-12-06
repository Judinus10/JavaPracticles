package Threads.HusbandWife;

import java.math.BigDecimal;

public class Wife implements Runnable {
    private final BankAccount account;

    public Wife(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            while (account.getBalance().compareTo(BigDecimal.valueOf(15000)) < 15000) {
                account.deposit(BigDecimal.valueOf(15000));
                System.out.println(Thread.currentThread().getName() + " deposited 15000. Current Balance: " + account.getBalance());
                try {
                    Thread.sleep(1000); // Simulate some delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
