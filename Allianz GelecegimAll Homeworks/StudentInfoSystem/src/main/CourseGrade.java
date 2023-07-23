package main;

import util.Grade;

public class CourseGrade {

    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 0, 0, 0);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 0, 0);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, 0);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, double gradeTaken) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.equals("CENG") ||
                courseDepartment.equals("COMP") ||
                courseDepartment.equals("ECE") ||
                courseDepartment.equals("ME") ||
                courseDepartment.equals("MATH")) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = "CENG";
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100;
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        if (val >= 0 && val <= 4) {
            int roundedScore = (int) Math.round(val);
            // Determines the grade based on the given score. Returns Grade.F if no match is found.
            this.gradeTaken = Grade.getGradeByNumericValue(roundedScore);
        } else {
            this.gradeTaken = Grade.F;
        }

    }

    public void setGradeTaken(Grade grade) {
        this.gradeTaken = grade;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment +
                " CourseCode: " + courseCode +
                " Credit: " + courseCredit +
                " Grade: " + gradeTaken.getStringValue();
    }
}
