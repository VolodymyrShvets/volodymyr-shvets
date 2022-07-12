package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.api.BankAccountApi;
import com.epam.paymentsystem.service.BankAccountService;
import com.epam.paymentsystem.service.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController implements BankAccountApi {
    private BankAccountService service;

    @Autowired
    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @Override
    public BankAccount getBankAccount(@PathVariable String bankAccountID) {
        return service.getBankAccount(bankAccountID);
    }

    @Override
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        return service.createBankAccount(bankAccount);
    }

    @Override
    public List<BankAccount> listAccounts(@RequestBody String userID) {
        return service.listAccounts(userID);
    }

    @Override
    public BankAccount blockAccount(@PathVariable String bankAccountID) {
        return service.blockAccount(bankAccountID);
    }

    @Override
    public BankAccount unblockAccount(@RequestBody String bankAccountID) {
        return service.unblockAccount(bankAccountID);
    }
}
