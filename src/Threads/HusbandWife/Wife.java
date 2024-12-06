package Threads.HusbandWife;

import java.math.BigDecimal;

public class Wife implements Runnable {
    BankAccount account;

    public Wife(BankAccount account){
        this.account=account;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            account.deposite(BigDecimal.valueOf(15000));
        }
    }
}
