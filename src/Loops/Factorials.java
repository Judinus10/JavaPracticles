package Loops;

import java.util.Scanner;

public class Factorials {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n=input.nextInt();
//        factorial of a given number using a loop.
//        forLoop
        int answer=1;
        for(int i=n;i>1;i--){
            answer*=i;
        }
        System.out.println("Factorial of "+n+" number is :"+answer);

//        while loop
        int factorial=1;
        int j=n;
        while(j>1){
            factorial*=j;
            j--;
        }
        System.out.println("Factorial of "+n+" number is :"+factorial);
    }
}
