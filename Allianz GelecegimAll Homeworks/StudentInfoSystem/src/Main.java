
import main.CourseGrade;
import main.Transcript;
import util.Grade;
import util.GradeTest;

public class Main {
    public static void main(String[] args) {
        new GradeTest().printTest();

        System.out.println("\n----------------------------\n");

        CourseGrade course1 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course2 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course3 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course4 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course5 = new CourseGrade("CENG", 201, 5, Grade.B);

        Transcript transcript = new Transcript(1234);

        transcript.addCourseTaken(course1);
        transcript.addCourseTaken(course2);
        transcript.addCourseTaken(course3);
        transcript.addCourseTaken(course4);
        transcript.addCourseTaken(course5);

        System.out.println(transcript);
    }
}