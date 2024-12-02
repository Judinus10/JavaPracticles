import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Declare Scanner once
        int sum = 0; // Initialize sum outside the loop

        for (int i = 1; i <= 2; i++) { // Loop twice for two numbers
            System.out.print("Enter the " + i + " number: ");
            int num = input.nextInt(); // Read each number
            sum += num; // Add the number to sum
        }

        System.out.println("The sum of the two numbers is: " + sum);
    }
}
