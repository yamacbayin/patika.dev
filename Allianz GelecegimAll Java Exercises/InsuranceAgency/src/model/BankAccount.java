package model;

import java.math.BigDecimal;

public class BankAccount {
    private String name;
    private String iban;
    private BigDecimal amount;

    public BankAccount() {
    }

    public BankAccount(String name, String iban, BigDecimal amount) {
        this.name = name;
        this.iban = iban;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", iban='" + iban + '\'' +
                ", amount=" + amount +
                '}';
    }
}
