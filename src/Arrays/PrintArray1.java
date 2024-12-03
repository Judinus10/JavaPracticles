package Arrays;

public class PrintArray1 {
    public static void main(String[] args){
        int[] array ={1,2,3,4,5,6,7,8};
//        array index start from 0 from beginning and -1 from the end
//  method 1
        for(int element : array){
            System.out.println(element);
        }
//  method 2
        for(int i=0;i< array.length;i++){
            System.out.println(array[i]);
        }
    }
}
