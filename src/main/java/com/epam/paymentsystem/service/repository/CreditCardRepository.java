package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.CreditCard;

import java.util.List;

public interface CreditCardRepository {
    CreditCard createCard(CreditCard creditCard);

    List<CreditCard> listCards(String accountID);
}
