package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.BankAccountService;
import com.epam.paymentsystem.service.model.BankAccount;
import com.epam.paymentsystem.service.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository repository;

    @Override
    public BankAccount getBankAccount(String bankAccountID) {
        log.info("get account by id {}", bankAccountID);
        return repository.getBankAccount(bankAccountID);
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        log.info("create new bankAccount with id {}", bankAccount.getAccountID());
        return repository.createBankAccount(bankAccount);
    }

    @Override
    public List<BankAccount> listAccounts(String userID) {
        log.info("get all accounts for user {}", userID);
        return repository.listAccounts(userID);
    }

    @Override
    public BankAccount blockAccount(String bankAccountID) {
        log.info("blocking account with id {}", bankAccountID);
        return repository.blockAccount(bankAccountID);
    }

    @Override
    public BankAccount unblockAccount(String bankAccountID) {
        log.info("unblocking account with id {}", bankAccountID);
        return repository.unblockAccount(bankAccountID);
    }
}
