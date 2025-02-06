package Arrays;

import java.util.Scanner;

public class removeDuplicate {
    public static void main (String[] args){
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
    }
}

