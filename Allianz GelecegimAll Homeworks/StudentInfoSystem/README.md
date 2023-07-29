# Student Transcript Generation Application

This is a Java application for generating transcripts of students. The application uses the `hw3.util` and `hw3.main` packages to organize its classes and functionalities.

## Getting Started

To run the application, you need Java Development Kit (JDK) installed on your system. You can compile and execute the code using any Java IDE or via the command line.

## Package Structure

The application is organized into two packages:

1. `hw3.util`: Contains the utility classes for the application.
    - `Grade`: An enum type representing the grade of a student with letter and numeric values.
    - `GradeTest`: A test program that uses the `Grade` enum to print grades and their numeric values.

2. `hw3.main`: Contains the main classes responsible for generating the student's transcript.
    - `CourseGrade`: Represents information about a course, its department, code, credit, and grade.
    - `Transcript`: Represents a student's transcript, keeping a list of `CourseGrade` objects and calculating GPA.
    - `GenerateTranscript`: A class with methods to take input from the user or a file and generate the student's transcript.

## Class Descriptions

- `Grade`: An enum type representing the letter grades (A, B, C, D, F) along with their numeric values. It provides a `toString()` method to display the grade details.

- `GradeTest`: A test program that uses the `Grade` enum to print out the letter grades and their corresponding numeric values.

- `CourseGrade`: Represents a course taken by a student, containing information about department, course code, credit, and grade. It includes get and set methods for the fields and provides overloaded constructors to handle different inputs.

- `Transcript`: Keeps the transcript of a student with their ID and a list of `CourseGrade` objects. It calculates and stores the GPA of the student based on the grades taken. It includes an `addCourseTaken()` method to add a course to the transcript.

- `GenerateTranscript`: The main class responsible for running the application. It provides methods to take input from the user or a file and generate the student's transcript.

## Running the Application

1. Compile the Java files in the `hw3` package.

2. Execute the `GenerateTranscript` class.

3. Choose between entering information manually or loading it from a file.

4. Follow the on-screen instructions to input course details and grades.

5. The application will print the student's transcript with the calculated GPA.

## Using the `takeInputFromFile` Method

1. Prepare a text file with course information for a student, where the first line is the student's ID and subsequent lines contain department, course code, credit, and grade.

2. Run the `GenerateTranscript` class.

3. Select the option to load information from a file.

4. Enter the filename when prompted.

5. The application will process the file and generate the student's transcript.

Feel free to reach out if you have any questions or need further assistance with the application.

---