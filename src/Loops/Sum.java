package Loops;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = input.nextInt();

//        calculate the sum of n numbers using loops
//        for loop
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        System.out.println("The total of "+n+" natural number is : "+sum);

//        while loop
        int j=0;
        int total=0;
        while(j<=n){
            total+=j;
            j++;
        }
        System.out.println("The total of "+n+" natural number is : "+total);
    }
}
