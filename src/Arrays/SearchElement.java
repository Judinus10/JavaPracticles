package Arrays;

import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        int[] array = {329, 219, 488, 93, 245, 481, 137, 257, 257, 383,
                295, 290, 295, 190, 221, 299, 263, 461, 271, 67,
                1, 149, 270, 271, 313, 177, 49, 358, 449, 165};

        System.out.println("Find an element from 1 to 500 in the ARRAY");
        Scanner input = new Scanner(System.in);

        System.out.print("Guess an element of the array: ");
        int guess = input.nextInt();

        boolean found = false;

        for (int element : array) {
            if (element == guess) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations, You guessed it right!");
        } else {
            System.out.println("OOPS! Not in Array");
        }

        input.close(); // Close scanner
    }
}
