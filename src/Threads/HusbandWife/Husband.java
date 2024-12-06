package Threads.HusbandWife;

import java.math.BigDecimal;

public class Husband implements Runnable{
    BankAccount account;

    public Husband(BankAccount account){
        this.account=account;
    }

    @Override
    public void run() {
        account.withdraw(BigDecimal.valueOf(10000));
    }
}
