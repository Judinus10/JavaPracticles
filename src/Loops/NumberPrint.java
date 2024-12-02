package Loops;

public class NumberPrint {
    public static void main(String[] args){
        //    print numbers from 1 to 10 using for loop and while loop

//        for loop
        for(int i=1; i<=10;i++){
            System.out.print(i+",");
        }
        System.out.println();

//    while loop
        int j=1;
        while(j<=10){
            System.out.print(j+",");
            j++;
        }
    }
}
