package Loops;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter a number to sum: ");
        int num = input.nextInt();

        // Using while loop
        int sumWhile = 0;
        int tempWhile = Math.abs(num); // To handle negative numbers
        while (tempWhile != 0) {
            int digit = tempWhile % 10;  // Extract the last digit
            sumWhile += digit;           // Add the digit to the sum
            tempWhile /= 10;             // Remove the last digit
        }
        System.out.println("Sum of digits (using while loop): " + sumWhile);

        // Using for loop
        int sumFor = 0;
        for (int tempFor = Math.abs(num); tempFor != 0; tempFor /= 10) {
            int digit = tempFor % 10;  // Extract the last digit
            sumFor += digit;           // Add the digit to the sum
        }
        System.out.println("Sum of digits (using for loop): " + sumFor);

        input.close();
    }
}
