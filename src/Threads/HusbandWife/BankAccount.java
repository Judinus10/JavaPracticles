package Threads.HusbandWife;

import java.math.BigDecimal;

public class BankAccount {
    int accNo;
    BigDecimal balance;

    public BankAccount(int accNo,BigDecimal balance){
        this.balance=balance;
        this.accNo=accNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal deposite(BigDecimal amount){
        while(balance.doubleValue()<15000){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance=balance.add(amount);
        notifyAll();
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount){
        while(balance.doubleValue()>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        balance= balance.subtract(amount);
        notifyAll();
        return  balance;
    }
}
