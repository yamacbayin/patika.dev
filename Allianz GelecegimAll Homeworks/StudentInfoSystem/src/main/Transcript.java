package main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private final int studentId;
    private List<CourseGrade> gradesList;
    private double gpa;

    public Transcript(int studentId) {
        this.studentId = studentId;
        this.gradesList = new ArrayList<>();
        this.gpa = 0;
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            gradesList.add(courseGrade);
            calculateGpa();
        } else {
            System.err.println("The CourseGrade object is null. Unable to add course.");
        }
    }

    private void calculateGpa() {
        int totalCredits = 0;
        int totalScores = 0;

        for (CourseGrade grade : gradesList) {
            totalCredits += grade.getCourseCredit();
            totalScores += grade.getGradeTaken().getNumericValue() * grade.getCourseCredit();
        }

        if (totalCredits > 0) {
            gpa = (double) totalScores / totalCredits;
        }
    }

    public List<CourseGrade> getGradesList() {
        return gradesList;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {

        StringBuilder grades = new StringBuilder();
        for (CourseGrade grade : gradesList) {
            grades.append(grade.toString()).append("\n");
        }

        return "Student ID: " + studentId + "\n" +
                grades +
                "GPA: " + gpa;
    }
}
