package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.api.CreditCardApi;
import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController implements CreditCardApi {
    private CreditCardService service;

    @Autowired
    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @Override
    public CreditCardDTO createCard(@RequestBody CreditCardDTO creditCardDTO) {
        return service.createCard(creditCardDTO);
    }

    @Override
    public List<CreditCardDTO> listCards(@RequestBody String accountID) {
        return service.listCards(accountID);
    }
}
