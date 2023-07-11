package service;

import model.*;

import java.util.List;

public class LectureService {

    public Lecture createNewLecture(String name, Instructor instructor, Branch branch, int capacity,
                                    List<LectureScheduleTime> lectureScheduleTimeList,
                                    List<Student> studentList) {
        return new Lecture(name, instructor, branch, capacity, lectureScheduleTimeList, studentList);
    }

}
