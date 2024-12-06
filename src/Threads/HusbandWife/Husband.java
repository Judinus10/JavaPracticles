package Threads.HusbandWife;

import java.math.BigDecimal;

public class Husband implements Runnable {
    private final BankAccount account;

    public Husband(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Perform 5 withdrawals
            synchronized (account) {
                account.withdraw(BigDecimal.valueOf(10000));
                System.out.println(Thread.currentThread().getName() + " withdrew 10000. Current Balance: " + account.getBalance());
            }
            try {
                Thread.sleep(1500); // Simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
