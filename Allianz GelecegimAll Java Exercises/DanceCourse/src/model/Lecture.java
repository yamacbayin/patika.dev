package model;

import java.util.List;

public class Lecture {

    private String name;

    private Instructor instructor;

    private Branch branch;

    private int capacity;

    private List<LectureScheduleTime> lectureScheduleTimeList;

    private List<Student> studentList;

    public Lecture(String name, Instructor instructor, Branch branch,
                   int capacity, List<LectureScheduleTime> lectureScheduleTimeList, List<Student> studentList) {
        this.name = name;
        this.instructor = instructor;
        this.branch = branch;
        this.capacity = capacity;
        this.lectureScheduleTimeList = lectureScheduleTimeList;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<LectureScheduleTime> getLectureScheduleTimeList() {
        return lectureScheduleTimeList;
    }

    public void setLectureScheduleTimeList(List<LectureScheduleTime> lectureScheduleTimeList) {
        this.lectureScheduleTimeList = lectureScheduleTimeList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
