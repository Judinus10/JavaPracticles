package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
class sharedResources {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void waitForCondition(int targetValue) throws InterruptedException {
        lock.lock();
        try {
            while (counter < targetValue) {
// Wait until the counter reaches the target value 
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
    public void incrementCounter() {
        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " - Counter Incremented: " +
                    counter);
// Signal waiting threads when the counter is incremented 
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
class sharedResourcesUser extends Thread {
    private final sharedResources sharedResources;

    public sharedResourcesUser(sharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }

    @Override
    public void run() {
        try {
// Wait for the condition (counter value) to be met 
            sharedResources.waitForCondition(5);
            System.out.println(Thread.currentThread().getName() + " - Condition Met!");
// Perform some task after the condition is met 
// For demonstration purposes, simply print a message 
            System.out.println(Thread.currentThread().getName() + " - Task Completed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ConcurrentProgramWithReentrantLock {
    public static void main(String[] args) {
        sharedResources sharedResources = new sharedResources();
// Creating multiple threads that use the shared resource 
        Thread thread1 = new sharedResourcesUser(sharedResources);
        Thread thread2 = new sharedResourcesUser(sharedResources);
// Starting the threads 
        thread1.start();
        thread2.start();
// Simulating the increment of the counter over time 
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000); // Simulating some delay 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedResources.incrementCounter();
        }
    }
}