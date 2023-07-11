package service;

import model.Branch;
import model.Instructor;
import model.Sex;

import java.math.BigDecimal;
import java.util.List;

public class InstructorService {

    public Instructor createNewInstructor(String name, List<Branch> branchList,
                                          int age, Sex sex, BigDecimal salary) {
        return new Instructor(name, branchList, age, sex, salary);
    }

}
