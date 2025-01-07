package Threads.couresWork.Scenario_1;

// Barista class implementing Runnable to prepare orders from the queue
public class Barista implements Runnable {
    private CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        String order = coffeeShop.prepareOrder(); // Prepare an order
        System.out.println(Thread.currentThread().getName() + " Order Prepare : " + order);
    }
}
