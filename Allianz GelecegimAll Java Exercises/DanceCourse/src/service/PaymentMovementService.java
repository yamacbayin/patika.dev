package service;

import model.BankAccount;
import model.MovementType;
import model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {

    public PaymentMovement createNewPaymentMovement(BankAccount bankAccount, String description,
                                                    MovementType movementType, BigDecimal amount) {
        return new PaymentMovement(bankAccount, description, movementType, amount);
    }

}
