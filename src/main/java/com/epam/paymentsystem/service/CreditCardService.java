package com.epam.paymentsystem.service;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;

import java.util.List;

public interface CreditCardService {
    CreditCardDTO createCard(CreditCardDTO creditCardDTO);

    List<CreditCardDTO> listCards(String accountID);
}
