package Threads;

// Create a thread by implementing the Runnable interface
// This is a preferred approach as it avoids single inheritance limitation
public class CreateThread2 implements Runnable {

    // The run() method defines the thread's execution behavior
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Current Thread: " + Thread.currentThread().getName() + " - Iteration: " + i);
        }
    }

    public static void main(String[] args) {
        // Create a Runnable instance
        Runnable t2 = new CreateThread2();

        // Pass the Runnable to a Thread object and name the thread
        Thread thread = new Thread(t2, "Thread2");

        // Start the thread
        thread.start();
    }
}
