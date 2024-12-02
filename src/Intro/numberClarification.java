package Intro;

import java.util.Scanner;

public class numberClarification {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x = "y"; // Initial value to enter the loop

        while (x.equalsIgnoreCase("Y")) { // Compare using equalsIgnoreCase
            System.out.print("Enter Number: ");
            int num = input.nextInt();

            // Check if the number is zero, negative, or positive
            if (num == 0) {
                System.out.println("Zero");
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Positive");
            }

            // Ask if the user wants to continue
            System.out.print("Do you want to continue? (Y/N): ");
            x = input.next(); // Get user input

            // Exit condition for "N"
            if (x.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Program ended. Goodbye!");
    }
}
