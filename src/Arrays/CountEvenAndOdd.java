package Arrays;

import java.util.Scanner;

public class CountEvenAndOdd {
    public static void main(String[] args) {

        // Count how many even and odd numbers are present in an array.
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

        int evenCount = 0, oddCount = 0;

        for (int element : array) {
            if (element % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of Even Numbers: " + evenCount);
        System.out.println("Number of Odd Numbers: " + oddCount);

        input.close();
    }
}
