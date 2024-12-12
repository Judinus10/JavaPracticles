//public class Plate {
//    private  String food;
//    private  boolean availability = false;
//
//    public synchronized void serve(String food){
//        while(availability){
//            try {
//                wait(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getStackTrace());
//            }
//        }
//        this.food=food;
//        availability=true;
//        notifyAll();
//    }
//
//    public synchronized String consume(){
//        while(!availability){
//            try {
//                wait(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getStackTrace());
//            }
//        }
//        availability=false;
//        return food;
////        notifyAll();
//    }
//}

package Threads.ProducerConsumer;
public class Source {
    private String food;
    private boolean fill = false ;

    public synchronized void serve(String food){
        while(fill){
            try {
                wait(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.food=food;
        fill=true;
        notifyAll();
    }

    public synchronized String consume(){
        while(!fill){
            try{
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fill=false;
        notifyAll();
        return food;
    }
}