package com.epam.paymentsystem.service.repository.impl;

import com.epam.paymentsystem.service.exception.BankAccountNotFoundException;
import com.epam.paymentsystem.service.model.BankAccount;
import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.repository.BankAccountRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountRepositoryImpl implements BankAccountRepository {
    private final List<BankAccount> list = new ArrayList<>();

    @Override
    public BankAccount getBankAccount(String bankAccountID) {
        return list.stream()
                .filter(
                        bankAccount -> String.valueOf(bankAccount.getAccountID()).equals(bankAccountID))
                .findFirst()
                .orElseThrow(BankAccountNotFoundException::new);
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        list.add(bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> listAccounts(String userID) {
        return new ArrayList<>(list);
    }

    @Override
    public BankAccount blockAccount(String bankAccountID) {
        BankAccount account = getBankAccount(bankAccountID);
        account.setStatus(Status.BLOCKED);
        return account;
    }

    @Override
    public BankAccount unblockAccount(String bankAccountID) {
        BankAccount account = getBankAccount(bankAccountID);
        account.setStatus(Status.ACTIVE);
        return account;
    }
}
