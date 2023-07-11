package service;

import model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {

    public BankAccount createNewBankAccount(String bankName, String ibanNo, String companyName,
                                            BigDecimal amount) {
        return new BankAccount(bankName, ibanNo, companyName, amount);
    }

}
