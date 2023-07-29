package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The GenerateTranscript class is responsible for generating a student's transcript based on
 * the user's input. The user can choose to enter the information manually or load it from a file.
 */
public class GenerateTranscript {

    private Scanner scanner;

    /**
     * Constructs a new GenerateTranscript object.
     * Initializes the scanner to read user input from the console.
     */
    public GenerateTranscript() {
        scanner = new Scanner(System.in);
    }


    /**
     * Displays a menu for the user to choose between manual input and loading from a file.
     * Based on the user's selection, this method calls the appropriate method to proceed.
     */
    public void chooseOption() {

        String info = """
                ------------- STUDENT INFO SYSTEM -------------
                Please choose an option from the following menu:
                1. Enter information manually
                2. Load information from a file""";

        System.out.println(info);
        int selection = getIntegerInputFromUser(1, 2);

        switch (selection) {
            case 1 -> takeInputFromUser();
            case 2 -> takeInputFromFile();
        }
    }

    /**
     * Takes input manually from the user to create a student's transcript.
     * The user can add multiple courses and grades until they choose to exit by pressing Ctrl + D.
     */
    private void takeInputFromUser() {
        System.out.println("Enter Student Id: ");
        int studentId = getIntegerInputFromUser(1, Integer.MAX_VALUE);
        Transcript transcript = new Transcript(studentId);

        while (true) {
            System.out.println("Add a new course to the student's transcript. Hit CTRL + D to break the loop.");
            try {
                String courseDepartment = "";
                int courseCode;
                int courseCredit;
                double gradeTaken;

                System.out.print("Enter Department: ");
                scanner.nextLine();
                boolean isCourseDepartmentValid = false;
                while (!isCourseDepartmentValid) {
                    courseDepartment = scanner.nextLine().trim();
                    if (courseDepartment.equals("CENG") ||
                            courseDepartment.equals("COMP") ||
                            courseDepartment.equals("ECE") ||
                            courseDepartment.equals("ME") ||
                            courseDepartment.equals("MATH")) {
                        isCourseDepartmentValid = true;
                    } else {
                        System.out.println("Enter a valid Course Department!");
                    }
                }
                System.out.print("Enter Course Code: ");
                courseCode = getIntegerInputFromUser(100, 599);
                System.out.print("Enter Credit: ");
                courseCredit = getIntegerInputFromUser(3, 4);
                System.out.print("Enter Grade: ");
                gradeTaken = getDoubleInputFromUser(0, 4);
                transcript.addCourseTaken(new CourseGrade(courseDepartment, courseCode, courseCredit, gradeTaken));
            } catch (NoSuchElementException e) {
                break;
            }
        }

        scanner.close();
        System.out.println("------------------------------------------");
        System.out.println(transcript);
    }

    /**
     * Prompts the user to enter a file path, reads the content from the file,
     * and returns the file content as a string.
     *
     * @return The content of the file as a string.
     */
    private String getFilePathFromUser() {
        System.out.println("Enter the file path: ");
        scanner.nextLine();
        StringBuilder fileContent = new StringBuilder();

        boolean readFileContent = false;
        while (!readFileContent) {

            String filePath = scanner.nextLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    fileContent.append(currentLine).append("\n");
                }
                readFileContent = true;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("File not found. Please provide a valid path: ");
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
        scanner.close();
        return fileContent.toString();

    }

    /**
     * Loads student information from a file and generates the student's transcript based on the data.
     * The file must contain the student ID in the first line, followed by course information in subsequent lines.
     * The course information must be in the format: "Department Code Credit Grade".
     */
    private void takeInputFromFile() {
        String fileContent = getFilePathFromUser();
        System.out.println("File content:\n" + fileContent);
        String[] fileParts = fileContent.split("\n");

        int studentId = Integer.parseInt(fileParts[0]);
        Transcript transcript = new Transcript(studentId);

        for (int i = 1; i < fileParts.length; i++) {
            String[] courseParts = fileParts[i].split(" ");
            String courseDepartment = courseParts[0];
            int courseCode = Integer.parseInt(courseParts[1]);
            int courseCredit = Integer.parseInt(courseParts[2]);
            double gradeTaken = Double.parseDouble(courseParts[3]);

            transcript.addCourseTaken(new CourseGrade(courseDepartment, courseCode, courseCredit, gradeTaken));
        }
        System.out.println("------------------------------------------");
        System.out.println(transcript);

    }

    /**
     * Reads an integer input from the user within the specified range (inclusive).
     * If the user enters an invalid input, this method prompts the user again until a valid input is provided.
     *
     * @param minInclusive The minimum value allowed for the input.
     * @param maxInclusive The maximum value allowed for the input.
     * @return The integer input provided by the user.
     */
    private int getIntegerInputFromUser(int minInclusive, int maxInclusive) {
        boolean isNumberInTheRange = true;
        int input;
        do {
            if (!isNumberInTheRange) {
                System.out.println("Enter a number between " + minInclusive + " and " + maxInclusive + ".");
            }
            isNumberInTheRange = false;
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a valid number!");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < minInclusive || input > maxInclusive);
        return input;
    }

    /**
     * Reads a double input from the user within the specified range (inclusive).
     * If the user enters an invalid input, this method prompts the user again until a valid input is provided.
     *
     * @param minInclusive The minimum value allowed for the input.
     * @param maxInclusive The maximum value allowed for the input.
     * @return The double input provided by the user.
     */
    private double getDoubleInputFromUser(double minInclusive, int maxInclusive) {
        boolean isDoubleInTheRange = true;
        double input;
        do {
            if (!isDoubleInTheRange) {
                System.out.println("Enter a number between " + minInclusive + " and " + maxInclusive + ".");
            }
            isDoubleInTheRange = false;
            while (!scanner.hasNextDouble()) {
                System.out.println("Enter a valid number!");
                scanner.next();
            }
            input = scanner.nextDouble();
        } while (input < minInclusive || input > maxInclusive);
        return input;
    }

}
