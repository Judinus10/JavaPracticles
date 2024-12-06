package Threads;

public class Lamda {
    final static Object r1 = new Object();
    final static Object r2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (r1){
                System.out.println("Acquire lock on r1");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Acquire lock on r2");
                synchronized (r2){
                    System.out.println("Working on r2");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (r1){
                System.out.println("Acquire lock on r1");
                try{
                        Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Acquire lock on r2");
            synchronized (r2){
                System.out.println("Working on r2");
            }
        });

        t1.start();
        t2.start();
    }
}
