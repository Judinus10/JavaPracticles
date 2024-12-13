package Threads.ProducerConsumer;

public class Main {
    public static void main(String[] args) {

        Source plate = new Source();
        Runnable producer = new Mother(plate);
        Runnable consumer = new Child(plate);

        Thread producerThread = new Thread(producer , "producer");
        //Where the initial thread is created
        System.out.println(Thread.currentThread().getName()+" : "+producerThread.getState());
        Thread consumerThread = new Thread(consumer , "consumer");
        System.out.println(Thread.currentThread().getName()+" : "+consumerThread.getState());
        //currently the producer and the consumer thread are in NEW state

        producerThread.start();
        consumerThread.start();
        System.out.println("After start");
        System.out.println(Thread.currentThread().getName()+" : "+producerThread.getState());
        System.out.println(Thread.currentThread().getName()+" : "+consumerThread.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After Interupted");
        System.out.println(Thread.currentThread().getName()+" : "+producerThread.getState());
        System.out.println(Thread.currentThread().getName()+" : "+consumerThread.getState());


    }
}