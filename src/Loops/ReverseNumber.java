package Loops;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter a number you want to reverse: ");
        int num = input.nextInt();

        // Using while loop
        int reverseWhile = 0;
        int tempWhile = num;
        while (tempWhile != 0) {
            int digit = tempWhile % 10; // Extract last digit
            reverseWhile = reverseWhile * 10 + digit; // Build the reversed number
            tempWhile /= 10; // Remove the last digit
        }
        System.out.println("Reversed number (using while loop): " + reverseWhile);

        // Using for loop
        int reverseFor = 0;
        for (int tempFor = num; tempFor != 0; tempFor /= 10) {
            int digit = tempFor % 10; // Extract last digit
            reverseFor = reverseFor * 10 + digit; // Build the reversed number
        }
        System.out.println("Reversed number (using for loop): " + reverseFor);

        input.close();
    }
}
