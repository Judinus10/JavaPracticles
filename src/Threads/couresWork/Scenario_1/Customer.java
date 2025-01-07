package Threads.couresWork.Scenario_1;

// Customer class implementing Runnable to place orders in the queue
public class Customer implements Runnable {
    private CoffeeShop coffeeShop;
    private String order;

    public Customer(CoffeeShop coffeeShop, String order) {
        this.coffeeShop = coffeeShop;
        this.order = order;
    }

    @Override
    public void run() {
        coffeeShop.placeOrder(order); // Place an order
        System.out.println(Thread.currentThread().getName() + " Order Placed Successfully : " + order);
    }
}