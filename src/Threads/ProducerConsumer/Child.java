//public class Child implements Runnable{
//    private Plate plate;
//
//    public Child(Plate plate){
//        this.plate=plate;
//    }
//    @Override
//    public void run(){
//        for(int i=1; i<=10; i++){
//            String food = Plate.consume();
//            System.out.println(Thread.currentThread().getName()+" "+i+" : "+ food);
//        }
//    }
//}

package Threads.ProducerConsumer;
class Child implements Runnable{
    Source plate;
    public Child(Source plate){
        this.plate=plate;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++) {
            String food = plate.consume();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

