package Loops;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a number to check if it is prime: ");
        int number = scanner.nextInt();

        // Check using for loop method
        System.out.println("Using FOR loop:");
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        // Check using while loop method
        System.out.println("\nUsing WHILE loop:");
        if (isPrimeWhile(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        scanner.close();
    }

    // Method to check if a number is prime using for loop
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        for (int i = 2; i <= Math.sqrt(number); i++) { // Check divisors up to the square root
            if (number % i == 0) {
                return false; // If divisible, not prime
            }
        }
        return true; // If no divisors found, it's prime
    }

    // Method to check if a number is prime using while loop
    public static boolean isPrimeWhile(int number) {
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        int i = 2; // Start from 2
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                return false; // If divisible, not prime
            }
            i++;
        }
        return true; // If no divisors found, it's prime
    }
}
