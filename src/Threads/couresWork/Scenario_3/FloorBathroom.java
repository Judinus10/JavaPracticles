package Threads.couresWork.Scenario_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FloorBathroom {

    private final int BATHROOM_STALLS; // Total number of stalls
    private final int EMPLOYEES; // Total number of users (employees/students)
    private int availableStalls; // Keeps track of available stalls
    private final Object lock = new Object(); // Lock object for synchronization

    // Constructor to initialize the bathroom with number of stalls and users
    public FloorBathroom(int stalls, int employees) {
        this.BATHROOM_STALLS = stalls;
        this.EMPLOYEES = employees;
        this.availableStalls = stalls; // Initially all stalls are available
    }

    // Method to simulate the bathroom usage (e.g., time spent)
    public void useBathroom(String user) {
        try {
            System.out.println(user + " is using the bathroom.");
            Thread.sleep(1000); // Simulate the time spent in the bathroom
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption
        } finally {
            leaveBathroom(user); // Ensure user leaves the bathroom after usage
        }
    }

    // Method for a person to enter the bathroom
    public void enterBathroom(String user) {
        synchronized (lock) { // Synchronize on lock object to ensure only one user at a time
            // Wait if no stalls are available
            while (availableStalls == 0) {
                System.out.println(user + " is waiting for a stall.");
                try {
                    lock.wait(); // Wait until a stall is available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle thread interruption
                }
            }
            availableStalls--; // A stall becomes unavailable
            System.out.println(user + " has entered the bathroom. Available stalls: " + availableStalls);
        }
        useBathroom(user); // Simulate the bathroom usage
    }

    // Method for a person to leave the bathroom and free a stall
    public void leaveBathroom(String user) {
        synchronized (lock) { // Synchronize on lock object to ensure only one user at a time
            availableStalls++; // A stall becomes available
            System.out.println(user + " has left the bathroom. Available stalls: " + availableStalls);
            lock.notifyAll(); // Notify all waiting users that a stall is now available
        }
    }

    // Main method to simulate the bathroom usage scenario
    public static void main(String[] args) {
        final int stalls = 6; // Number of bathroom stalls
        final int employees = 10; // Number of employees/students
        FloorBathroom bathroom = new FloorBathroom(stalls, employees); // Initialize the bathroom

        ExecutorService executor = Executors.newFixedThreadPool(employees); // Executor for handling threads

        // Simulate each user entering the bathroom
        for (int i = 1; i <= employees; i++) {
            final String user = "User" + i; // Create a unique user
            executor.execute(() -> bathroom.enterBathroom(user)); // Assign task to executor
        }

        executor.shutdown(); // Shutdown the executor after all tasks are done
    }
}
