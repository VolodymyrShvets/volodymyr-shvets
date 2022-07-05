package com.epam.paymentsystem.service;

import com.epam.paymentsystem.service.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount getBankAccount(String bankAccountID);

    BankAccount createBankAccount(BankAccount bankAccount);

    List<BankAccount> listAccounts(String userID);

    BankAccount blockAccount(String bankAccountID);

    BankAccount unblockAccount(String bankAccountID);
}
