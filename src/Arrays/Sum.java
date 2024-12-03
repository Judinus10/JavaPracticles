package Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int len = input.nextInt();

        int[] array = new int[len];

        // Input elements into the array
        for (int i = 0; i < len; i++) {
            System.out.print("Enter element no " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        // Calculate the sum of the elements
        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        // Print the sum
        System.out.println("The sum of the elements of the array is: " + sum);

        input.close(); // Close the scanner
    }
}
