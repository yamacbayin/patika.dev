package util;

import java.util.Scanner;

public class UserInputHelper {

    public static int takeIntegerInput(Scanner scanner, int minInclusive, int maxInclusive) {
        int input = Integer.MIN_VALUE;
        do {
            if(scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input < minInclusive || input > maxInclusive) {
                    System.err.println("Please enter a number within the valid range " +
                            "(" + minInclusive + " - " + maxInclusive + "):");
                }
            } else {
                System.err.println("Invalid input! Please enter a valid number:");
                scanner.next();
            }
        } while (input < minInclusive || input > maxInclusive);

        return --input;
    }

}
