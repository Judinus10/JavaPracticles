package Threads;

// Create a thread using a lambda function
public class CreateThread3 {

    public static void main(String[] args) {

        // Create and start a thread using a lambda function
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Current Thread: " + Thread.currentThread().getName() + " - Iteration: " + i);
            }
        }, "LambdaThread");

        // Start the thread
        thread.start();
    }
}
