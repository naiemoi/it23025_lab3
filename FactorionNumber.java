import java.util.Scanner;

public class FactorionNumber {

    // Method to calculate factorial of a digit
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is a factorion
    public static boolean isFactorion(int number) {
        int originalNumber = number;
        int sum = 0;

        // Calculate the sum of the factorials of the digits
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }

        // Return true if the sum equals the original number
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Factorion Number Finder");

        // Input range with validation
        int lowerBound, upperBound;

        while (true) {
            System.out.print("Enter the lower bound of the range: ");
            lowerBound = scanner.nextInt();

            System.out.print("Enter the upper bound of the range: ");
            upperBound = scanner.nextInt();

            if (lowerBound <= upperBound) {
                break; // Valid range
            } else {
                System.out.println("Invalid range. The lower bound must be less than or equal to the upper bound.");
            }
        }

        System.out.println("Factorion numbers in the range:");
        boolean found = false;

        // Find factorion numbers in the given range
        for (int i = lowerBound; i <= upperBound; i++) {
            if (isFactorion(i)) {
                System.out.println(i);
                found = true;
            }
        }

        // Message if no factorion numbers are found
        if (!found) {
            System.out.println("No factorion numbers found in the given range.");
        }

        scanner.close();
    }
}
