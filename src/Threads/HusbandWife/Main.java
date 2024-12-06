package Threads.HusbandWife;

import java.math.BigDecimal;

public class Main {
//    A husband and wife managing a bank account where the wife deposits money if the balance drops below 10,000.
//    Both the husband and wife may check the account and perform actions,
//    but they must not do so at the same time to avoid inconsistencies
    public static void main(String[] args){
        BigDecimal initialBalance = new BigDecimal("24000.00");
        BankAccount account = new BankAccount(12345678,initialBalance);

        Runnable husband = new Husband(account);
        Runnable wife = new Wife(account);

        Thread wifeThread = new Thread(wife,"Wife");
        Thread husbandThread = new Thread(husband,"Husband");

        wifeThread.start();
        husbandThread.start();
    }

}
