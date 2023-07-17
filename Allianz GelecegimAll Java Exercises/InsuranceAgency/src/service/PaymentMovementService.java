package service;

import model.BankAccount;
import model.MovementTypeEnum;
import model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {

    public PaymentMovement createPaymentMovement(BankAccount bankAccount, String description, MovementTypeEnum movementTypeEnum,
                                                 BigDecimal amount) {
        PaymentMovement paymentMovement = new PaymentMovement();
        paymentMovement.setBankAccount(bankAccount);
        paymentMovement.setDescription(description);
        paymentMovement.setMovementType(movementTypeEnum);
        paymentMovement.setAmount(amount);
        return paymentMovement;
    }

}
