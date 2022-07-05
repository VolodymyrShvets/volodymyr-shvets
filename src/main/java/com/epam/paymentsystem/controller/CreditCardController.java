package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditCardController {
    private CreditCardService service;

    @Autowired
    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/card")
    public CreditCardDTO createCard(@RequestBody CreditCardDTO creditCardDTO) {
        return service.createCard(creditCardDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/card")
    public List<CreditCardDTO> listCards(@RequestBody String accountID) {
        return service.listCards(accountID);
    }
}
