package Loops;

public class EvenAndOdd {
//    Print all even and odd numbers from 1 to 50.
    public static void main(String[] args) {
//        for loop
        for(int i=1; i<=50;i++){
            if(i%2==0){
                System.out.println(i+" is a Even Number");
            }else{
                System.out.println(i+" is a Odd number");
            }
        }

        System.out.println();//for a blank space

//        while loop
        int j=1;
        while(j<=50){
            if(j%2==0){
                System.out.println(j+" is a Even Number");
            }else{
                System.out.println(j+" is a Odd number");
            }
            j++;
        }
    }
}
