package Loops;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter a number you want to count the number of digits: ");
        int num = input.nextInt();

        // Using for loop
        int countForLoop = 0;
        for (int temp = Math.abs(num); temp > 0; temp /= 10) {
            countForLoop++;
        }

        System.out.println("Number of digits (using for loop): " + countForLoop);

        // Using while loop
        int countWhileLoop = 0;
        int tempNum = Math.abs(num); // Handle negative numbers
        while (tempNum > 0) {
            tempNum /= 10;
            countWhileLoop++;
        }

        System.out.println("Number of digits (using while loop): " + countWhileLoop);

        input.close();
    }
}
