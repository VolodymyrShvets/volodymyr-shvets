package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.CreditCardService;
import com.epam.paymentsystem.service.mapper.CreditCardMapper;
import com.epam.paymentsystem.service.model.CreditCard;
import com.epam.paymentsystem.service.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;

    @Override
    public CreditCardDTO createCard(CreditCardDTO creditCardDTO) {
        log.info("createCreditCard with CardNumber {}", creditCardDTO.getCardNumber());
        CreditCard creditCard = creditCardRepository.createCard(CreditCardMapper.INSTANCE.mapCreditCard(creditCardDTO));
        return CreditCardMapper.INSTANCE.mapCreditCardDto(creditCard);
    }

    @Override
    public List<CreditCardDTO> listCards(String accountID) {
        log.info("get all creditCards for account {}", accountID);
        return creditCardRepository.listCards(accountID)
                .stream()
                .map(CreditCardMapper.INSTANCE::mapCreditCardDto)
                .collect(Collectors.toList());
    }

    private CreditCardDTO mapCardToCardDto(CreditCard creditCard) {
        return CreditCardDTO.builder()
                .cardNumber(creditCard.getCardNumber())
                .accountID(creditCard.getAccountID())
                .expirationDate(creditCard.getExpirationDate())
                .moneyAmount(creditCard.getMoneyAmount())
                .build();
    }

    private CreditCard mapCardDtoToCard(CreditCardDTO creditCardDTO) {
        return CreditCard.builder()
                .cardNumber(creditCardDTO.getCardNumber())
                .accountID(creditCardDTO.getAccountID())
                .expirationDate(creditCardDTO.getExpirationDate())
                .moneyAmount(creditCardDTO.getMoneyAmount())
                .build();
    }
}
