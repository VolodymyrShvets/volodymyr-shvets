package com.epam.paymentsystem.service.mapper.impl;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.mapper.CreditCardMapper;
import com.epam.paymentsystem.service.model.CreditCard;

public class CreditCardMapperImpl implements CreditCardMapper {
    @Override
    public CreditCardDTO mapCreditCardDto(CreditCard card) {
        if (card == null)
            throw new RuntimeException("CreditCard is Null!!!");

        return CreditCardDTO.builder()
                .cardNumber(card.getCardNumber())
                .account(card.getAccount())
                .expirationDate(card.getExpirationDate())
                .moneyAmount(card.getMoneyAmount())
                .build();
    }

    @Override
    public CreditCard mapCreditCard(CreditCardDTO cardDto) {
        if (cardDto == null)
            throw new RuntimeException("CreditCardDTO is Null!!!");

        return CreditCard.builder()
                .cardNumber(cardDto.getCardNumber())
                .account(cardDto.getAccount())
                .expirationDate(cardDto.getExpirationDate())
                .moneyAmount(cardDto.getMoneyAmount())
                .build();
    }
}
