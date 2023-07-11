package model;

public class LectureScheduleTime {

    private Day day;

    private String time;

    public LectureScheduleTime(Day day, String time) {
        this.day = day;
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
