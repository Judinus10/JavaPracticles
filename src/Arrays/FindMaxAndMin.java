package Arrays;

import java.util.Scanner;

public class FindMaxAndMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input the length of the array
        System.out.print("Enter the array length: ");
        int len = input.nextInt();

        if (len <= 0) {
            System.out.println("Array length must be greater than 0.");
            return;
        }

        int[] array = new int[len];

        // Input the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < len; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        // Initialize max and min with the first element of the array
        int max = array[0];
        int min = array[0];

        // Find the max and min using enhanced for-loop
        for (int element : array) {
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
        }

        // Output the results
        System.out.println("Maximum of the array is: " + max);
        System.out.println("Minimum of the array is: " + min);

        input.close(); // Close the scanner
    }
}
