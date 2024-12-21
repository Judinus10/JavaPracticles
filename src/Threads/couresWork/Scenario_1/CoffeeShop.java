package Threads.couresWork.Scenario_1;

//passive monitor object called by customer and barista threads
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private Queue<String> orderQueue;
    private int capacity;

    public CoffeeShop( int capacity) {
        super();
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();
    }
    //Customer will call the placeOrder.
    public synchronized void placeOrder(String order){
        while (orderQueue.size()==capacity) {//if the queue is full the cannot place the order
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderQueue.offer(order);
        notifyAll();
    }
    //The Barista will call the prepareOrder method.
    public synchronized String prepareOrder(){
        while(orderQueue.isEmpty()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return orderQueue.poll();
    }

}


