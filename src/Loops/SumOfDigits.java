package Loops;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter a number to sum: ");
        int num = input.nextInt();

        // Edge case for 0
        if (num == 0) {
            System.out.println("Sum of digits: 0 (since 0 has no other digits)");
        } else {
            // Using while loop
            int sumWhile = sumDigitsUsingWhileLoop(num);
            System.out.println("Sum of digits (using while loop): " + sumWhile);

            // Using for loop
            int sumFor = sumDigitsUsingForLoop(num);
            System.out.println("Sum of digits (using for loop): " + sumFor);
        }

        input.close();
    }

    // Method to sum digits using a while loop
    public static int sumDigitsUsingWhileLoop(int num) {
        int sum = 0;
        int tempWhile = Math.abs(num); // Handle negative numbers
        while (tempWhile != 0) {
            int digit = tempWhile % 10; // Extract the last digit
            sum += digit;               // Add the digit to the sum
            tempWhile /= 10;            // Remove the last digit
        }
        return sum;
    }

    // Method to sum digits using a for loop
    public static int sumDigitsUsingForLoop(int num) {
        int sum = 0;
        for (int tempFor = Math.abs(num); tempFor != 0; tempFor /= 10) {
            int digit = tempFor % 10; // Extract the last digit
            sum += digit;             // Add the digit to the sum
        }
        return sum;
    }
}
