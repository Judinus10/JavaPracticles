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

    public static class Fibonacci {
        public static void main(String[] args) {

    //        The Fibonacci numbers are a sequence of numbers where each number is the sum of the two preceding ones, starting from 0 and 1
    //        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

            Scanner input = new Scanner(System.in);

            // Ask the user for the number of terms
            System.out.print("Enter the number of terms: ");
            int n = input.nextInt();

            // Variables to store the first two terms
            int first = 0, second = 1;

            System.out.println("Fibonacci Sequence:");

            // Print the Fibonacci sequence
            for (int i = 1; i <= n; i++) {
                System.out.print(first + " ");

                // Calculate the next term
                int next = first + second;
                first = second;
                second = next;
            }
        }
    }
}
