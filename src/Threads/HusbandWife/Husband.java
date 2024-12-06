package Threads.HusbandWife;

import java.math.BigDecimal;

public class Husband implements Runnable {
    private final BankAccount account;

    public Husband(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Withdraw 5 times

            account.withdraw(BigDecimal.valueOf(10000));
            try {
                Thread.sleep(1500); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
