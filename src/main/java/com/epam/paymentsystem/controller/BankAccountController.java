package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.service.BankAccountService;
import com.epam.paymentsystem.service.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountService service;

    @Autowired
    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/{bankAccountID}")
    public BankAccount getBankAccount(@PathVariable String bankAccountID) {
        return service.getBankAccount(bankAccountID);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/account")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        return service.createBankAccount(bankAccount);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account")
    public List<BankAccount> listAccounts(@RequestBody String userID) {
        return service.listAccounts(userID);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/account/{bankAccountID}")
    public BankAccount blockAccount(@PathVariable String bankAccountID) {
        return service.blockAccount(bankAccountID);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/account")
    public BankAccount unblockAccount(@RequestBody String bankAccountID) {
        return service.unblockAccount(bankAccountID);
    }
}
