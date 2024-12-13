package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrentLock {
    ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();  // Acquiring the lock
        try {
            System.out.println("Inside method A");
            methodB(); // Calls another method that also uses the same lock
        } finally {
            lock.unlock();  // Releasing the lock
        }
    }

    public void methodB() {
        lock.lock();  // Re-entering the same lock
        try {
            System.out.println("Inside method B");
        } finally {
            lock.unlock();  // Releasing the lock
        }
    }

}
