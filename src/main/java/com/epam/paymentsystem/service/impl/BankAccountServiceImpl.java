package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.BankAccountService;
import com.epam.paymentsystem.service.exception.exists.BanAccountAlreadyExistedWithIdException;
import com.epam.paymentsystem.service.exception.notfound.BankAccountNotFoundException;
import com.epam.paymentsystem.service.model.BankAccount;
import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository repository;

    @Override
    public BankAccount getBankAccount(String bankAccountID) {
        log.info("Getting Account by id {}", bankAccountID);
        BankAccount account = repository.findByAccountID(bankAccountID).orElseThrow(BankAccountNotFoundException::new);
        log.info("Bank Account with ID {} is found", bankAccountID);
        return account;
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        log.info("Creating new Bank Account with id {}", bankAccount.getAccountID());
        if (repository.existsByAccountID(String.valueOf(bankAccount.getAccountID()))) {
            throw new BanAccountAlreadyExistedWithIdException(bankAccount.getAccountID());
        }
        bankAccount = repository.save(bankAccount);
        log.info("Bank Account with id {} successfully created", bankAccount.getAccountID());
        return bankAccount;
    }

    @Override
    public List<BankAccount> listAccounts(String userID) {
        log.info("Getting all Accounts for User {}", userID);
        if (!repository.existsByUserID(userID))
            return new ArrayList<>();
        return repository.findByUser(userID);
    }

    @Override
    public BankAccount blockAccount(String bankAccountID) {
        log.info("Blocking Account with id {}", bankAccountID);
        BankAccount persistedAccount = repository.findByAccountID(bankAccountID).orElseThrow(BankAccountNotFoundException::new);
        persistedAccount.setStatus(Status.BLOCKED);
        BankAccount storedAccount = repository.save(persistedAccount);
        log.info("Bank Account with id {} successfully blocked", bankAccountID);
        return storedAccount;
    }

    @Override
    public BankAccount unblockAccount(String bankAccountID) {
        log.info("Unlocking Account with id {}", bankAccountID);
        BankAccount persistedAccount = repository.findByAccountID(bankAccountID).orElseThrow(BankAccountNotFoundException::new);
        persistedAccount.setStatus(Status.ACTIVE);
        BankAccount storedAccount = repository.save(persistedAccount);
        log.info("Bank Account with id {} successfully unblocked", bankAccountID);
        return storedAccount;
    }
}
