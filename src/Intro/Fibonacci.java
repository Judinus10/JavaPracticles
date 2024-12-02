package Intro;

import java.util.Scanner;

public class Fibonacci {
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
