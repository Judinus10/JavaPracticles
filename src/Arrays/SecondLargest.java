package Arrays;

import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
//        a program to find the second largest number in an array without sorting.
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

//       // Bubble Sort Implementation
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        int secondLargest=array[arrayLength-2];
        System.out.println("Second Largest element in Array is :"+secondLargest);
        input.close();
    }
}