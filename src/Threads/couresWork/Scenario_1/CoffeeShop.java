package Threads.couresWork.Scenario_1;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private Queue<String> orderQueue;
    private int capacity;

    // Constructor to initialize the coffee shop with a fixed capacity
    public CoffeeShop(int capacity) {
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();
    }

    // Customer places an order. Waits if the queue is full.
    public synchronized void placeOrder(String order) {
        while (orderQueue.size() == capacity) { // Wait if the queue is full
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderQueue.offer(order); // Add order to the queue
        notifyAll(); // Notify Barista
    }

    // Barista prepares an order. Waits if the queue is empty.
    public synchronized String prepareOrder() {
        while (orderQueue.isEmpty()) { // Wait if the queue is empty
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll(); // Notify Customer
        return orderQueue.poll(); // Process the next order
    }
}
