package com.epam.paymentsystem.service.repository.impl;

import com.epam.paymentsystem.service.model.CreditCard;
import com.epam.paymentsystem.service.repository.CreditCardRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditCardRepositoryImpl {//implements CreditCardRepository {
    private final List<CreditCard> list = new ArrayList<>();

    ///@Override
    public CreditCard createCard(CreditCard creditCard) {
        list.add(creditCard);
        return creditCard;
    }

    /*@Override
    public List<CreditCard> listCards(String accountID) {
        return list.stream().
                filter(creditCard ->
                        String.valueOf(creditCard.getAccountID()).equals(accountID)).
                collect(Collectors.toList());
    }*/
}
