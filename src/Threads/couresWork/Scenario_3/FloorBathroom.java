package Threads.couresWork.Scenario_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FloorBathroom {

    private final int BATHROOM_STALLS;
    private final int EMPLOYEES;
    private int availableStalls;
    private final Object lock = new Object();

    // Constructor
    public FloorBathroom(int stalls, int employees) {
        this.BATHROOM_STALLS = stalls;
        this.EMPLOYEES = employees;
        this.availableStalls = stalls;
    }

    // Method to simulate using the bathroom
    public void useBathroom(String user) {
        try {
            System.out.println(user + " is using the bathroom.");
            Thread.sleep(1000); // Simulate time spent in the bathroom
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            leaveBathroom(user);
        }
    }

    // Method for a person to enter the bathroom
    public void enterBathroom(String user) {
        synchronized (lock) {
            while (availableStalls == 0) {
                System.out.println(user + " is waiting for a stall.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            availableStalls--;
            System.out.println(user + " has entered the bathroom. Available stalls: " + availableStalls);
        }
        useBathroom(user);
    }

    // Method for a person to leave the bathroom
    public void leaveBathroom(String user) {
        synchronized (lock) {
            availableStalls++;
            System.out.println(user + " has left the bathroom. Available stalls: " + availableStalls);
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        final int stalls = 6;
        final int employees = 10;
        FloorBathroom bathroom = new FloorBathroom(stalls, employees);

        ExecutorService executor = Executors.newFixedThreadPool(employees);

        for (int i = 1; i <= employees; i++) {
            final String user = "User" + i;
            executor.execute(() -> bathroom.enterBathroom(user));
        }

        executor.shutdown();
    }
}
