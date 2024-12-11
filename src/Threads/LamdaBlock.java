package Threads;

public class LamdaBlock {
    final static Object r1 = new Object();
    final static Object r2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println(Thread.currentThread().getName() + " acquired the lock on r1");

                try {
                    Thread.sleep(100); // Simulate some work with r1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " trying to acquire the lock on r2");
                synchronized (r2) {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock on r2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println(Thread.currentThread().getName() + " acquired the lock on r2");

                try {
                    Thread.sleep(100); // Simulate some work with r2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " trying to acquire the lock on r1");
                synchronized (r1) {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock on r1");
                }
            }
        });

        t1.start();
        t2.start();

        // Wait for some time and check the state of threads
        try {
            Thread.sleep(1000); // Allow time for deadlock to occur
            System.out.println(t1.getName() + " State: " + t1.getState());
            System.out.println(t2.getName() + " State: " + t2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
