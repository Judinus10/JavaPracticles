package Arrays;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        //        Reverse the elements of an array using a loop.
        //        Example: Input [1, 2, 3, 4, 5] → Output [5, 4, 3, 2, 1]
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Array Length: ");
        int arrayLength = input.nextInt();

        if (arrayLength <= 0) {
            System.out.println("Invalid array length. Exiting program.");
            input.close();
            return;
        }

        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.print("Enter element no " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        System.out.print("Array: { ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("}");

        System.out.print("Reverse of Array: { ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");

        input.close(); // Close the Scanner
    }
}
