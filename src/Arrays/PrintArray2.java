package Arrays;

import java.util.Scanner;

public class PrintArray2 {
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

        // Display the elements of the array
        System.out.print("Array elements are: { ");
        for (int element : array) {
            System.out.print(element+" ");
        }
        System.out.println("}");

        input.close(); // Close Scanner
    }
}
