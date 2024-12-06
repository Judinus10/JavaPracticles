package Threads;

// Creating Threads by extending the Thread class.
// Note: This is not always the best approach due to single inheritance limitation in Java.
// It is often better to implement the Runnable interface.
public class CreateThread1 extends Thread {

    // Constructor to name the thread
    public CreateThread1(String name) {
        super(name);
    }

    // The run() method defines the thread's execution behavior
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Print the current thread's name and iteration count
            System.out.println("Current Thread: " + Thread.currentThread().getName() + " - Iteration: " + (i + 1));
        }
    }

    public static void main(String[] args) {
        // Create a thread with a specific name
        Thread t1 = new CreateThread1("Thread1");

        // Start the thread (preferred way to run a thread)
        t1.start();
    }
}
