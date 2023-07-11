package service;

import model.Sex;
import model.Student;

import java.math.BigDecimal;
import java.util.Date;

public class StudentService {

    public Student createNewStudent(String name, int age, Sex sex, boolean isPaid, BigDecimal contractAmount,
                                    Date startDate, Date endDate) {
        return new Student(name, age, sex, isPaid, contractAmount, startDate, endDate);
    }

}
