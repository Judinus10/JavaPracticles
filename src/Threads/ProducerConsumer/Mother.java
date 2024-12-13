//public class Mother implements Runnable{
//    private Plate plate;
//
//    public Mother(Plate plate){
//        this.plate=plate;
//    }
//    @Override
//    public void run(){
//        for(int i=1; i<=10; i++){
//            plate.serve("food"+i);
//            System.out.println(Thread.currentThread().getName()+" food"+i);
//        }
//    }
//}

package Threads.ProducerConsumer;
public class Mother implements Runnable{
    Source plate;
    public Mother(Source plate){
        this.plate=plate;
    }
    @Override
    public void run(){
        for(int i=0 ; i<10 ; i++){
            plate.serve("Food"+i);
            System.out.println("Current Thread"+i+" : "+Thread.currentThread().getName());
        }
    }
}