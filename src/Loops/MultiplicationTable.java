package Loops;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Generate and print the multiplication table of a number entered by the user.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to generate its multiplication table: ");
        int num = input.nextInt();

        System.out.print("Enter how many multiples you need: ");
        int multi = input.nextInt();

        if (num <= 0 || multi <= 0) {
            System.out.println("Please enter positive integers only.");
        } else {
            System.out.println("\nMultiplication Table for " + num + " using FOR loop:");
            // Using for loop
            for (int i = 1; i <= multi; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }

            System.out.println("\nMultiplication Table for " + num + " using WHILE loop:");
            // Using while loop
            int j = 1;
            while (j <= multi) {
                System.out.println(num + " x " + j + " = " + (num * j));
                j++;
            }
        }

        input.close(); // Close the scanner
    }
}
