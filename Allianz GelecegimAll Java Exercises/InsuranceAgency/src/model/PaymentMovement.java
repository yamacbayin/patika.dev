package model;

import java.math.BigDecimal;

public class PaymentMovement {

    private BankAccount bankAccount;
    private String description;
    private MovementTypeEnum movementTypeEnum;
    private BigDecimal amount;

    public PaymentMovement() {
    }

    public PaymentMovement(BankAccount bankAccount, String description, MovementTypeEnum movementTypeEnum, BigDecimal amount) {
        this.bankAccount = bankAccount;
        this.description = description;
        this.movementTypeEnum = movementTypeEnum;
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovementTypeEnum getMovementType() {
        return movementTypeEnum;
    }

    public void setMovementType(MovementTypeEnum movementTypeEnum) {
        this.movementTypeEnum = movementTypeEnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentMovement{" +
                "bankAccount=" + bankAccount +
                ", description='" + description + '\'' +
                ", movementTypeEnum=" + movementTypeEnum +
                ", amount=" + amount +
                '}';
    }
}
