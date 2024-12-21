package Threads.couresWork.Scenario_1;

public class Barista implements Runnable{
    private CoffeeShop coffeeShop;

    public Barista (CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        String order = coffeeShop.prepareOrder();
        System.out.println(Thread.currentThread().getName()+" Order Prepare : "+ order);
    }
}

