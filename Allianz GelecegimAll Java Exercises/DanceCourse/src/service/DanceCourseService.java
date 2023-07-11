package service;

import model.*;

import java.util.List;

public class DanceCourseService {

    public DanceCourse createNewDanceCourse(String name, String address, String founder,
                                            String taxNumber, String taxOffice,
                                            List<BankAccount> bankAccountList,
                                            List<PaymentMovement> paymentMovementList,
                                            List<Instructor> instructorList,
                                            List<Student> studentList)  {
        return new DanceCourse(name, address, founder, taxNumber, taxOffice,
                bankAccountList, paymentMovementList, instructorList, studentList);
    }

}
