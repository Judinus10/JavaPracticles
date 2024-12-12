package Threads.ThreadGroup;

import java.lang.reflect.Array;
public class ThreadGroup {
    public static void main(String[] args) {
        Thread[] threads = new Thread[8];
        java.lang.ThreadGroup[] groups = new java.lang.ThreadGroup[6];

        threads[0] = Thread.currentThread();
        java.lang.ThreadGroup group = Thread.currentThread().getThreadGroup();

//        ThreadGroup A = new ThreadGroup("A");
//        ThreadGroup B = new ThreadGroup("B");
//        ThreadGroup C = new ThreadGroup("C");

        // The threead group A,B,C belongs to main thread group
        //thread group created using the 1st constructor and parent is not specified
        // since parent is not specified main thread creates these 3 thread groups
        // main thread belongs to the main thread group therefore these 3 thered groups belongs to the main thread group
        groups[1] = new java.lang.ThreadGroup( "A");
        groups[2] = new java.lang.ThreadGroup("B");
        groups[3] = new java.lang.ThreadGroup("C");

        //for thread group B1 and B2 second constructor is used
        // 1st parameter is the parent thread group and 2nd parameter is the name
        //therefore B1 and B2 belongs to the threadgroup B
        //parent of B1 and B2 is B
        groups[4] = new java.lang.ThreadGroup(groups[2], "B1");
        groups[5] = new java.lang.ThreadGroup(groups[2], "B2");

        threads[1] = new Thread(new myRunnable(),"Thread1");
        threads[2] = new Thread(groups[1],new myRunnable(),"Thread2");

        threads[3] = new Thread(groups[1],new myRunnable(),"Thread3");

        threads[4] = new Thread(groups[3],new myRunnable(),"Thread 4");
        threads[5] = new Thread(groups[4],new myRunnable(),"Thread 5");
        threads[6] = new Thread(groups[4],new myRunnable(),"Thread 6");

        threads[7] = new Thread(groups[5],new myRunnable(),"Thread 7");

        for (Thread t:threads){
            if (t != null && !t.getName().equals("main")){
                t.start();
            }
        }
//        for (ThreadGroup tg: groups){
//            if (!tg.getName().equals("main")){
//                tg
//            }
//        }

        // Getting the estimated count of active threads
        // not the actual count
        int activeThreadCount = Thread.currentThread().getThreadGroup().activeCount();

        //Getting the estimated count of active thread groups
        // not the actual count of thread groups
        int activeThreadGroupCount = Thread.currentThread().getThreadGroup().activeGroupCount();

        //Creating a thread array with size of twice the active count
        // this to be on the safer side because the actual thread count maybe larger
        Thread[] enumarateThreads = new Thread[activeThreadCount*2];

        // creating an array of thread groups with the size of twice the active group count
        java.lang.ThreadGroup[] enumarateThreadGroups = new java.lang.ThreadGroup[activeThreadGroupCount*2];

        // we use enumarate method and pass the thread array as the parameter
        // as the parameter to enumarate the active threads in the main thread group and its sub group
        // (that's why we pass the 2nd para as true to retrive threads from the sub groups recursively)
        // enumarated threads will be put on the 1st parameter
        Thread.currentThread().getThreadGroup().enumerate(enumarateThreads,true);
        Thread.currentThread().getThreadGroup().enumerate(enumarateThreadGroups,true);


        System.out.println("List of Active Threads");
        for (Thread enumarateThread: enumarateThreads ){
            if (enumarateThread != null){
                System.out.println(enumarateThread.getName());

            }
        }

        System.out.println("List of Active Thread Groups");
        for (java.lang.ThreadGroup enumarateThreadGroup: enumarateThreadGroups ){
            if (enumarateThreadGroup != null){
                System.out.println(enumarateThreadGroup.getName());

            }
        }


    }
}
