package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.CreditCardService;
import com.epam.paymentsystem.service.exception.exists.CreditCardAlreadyExistsException;
import com.epam.paymentsystem.service.exception.notfound.CreditCardNotFoundException;
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
        log.info("Creating CreditCard with CardNumber {}", creditCardDTO.getCardNumber());
        if (creditCardRepository.existsByCardNumber(String.valueOf(creditCardDTO.getCardNumber()))) {
            throw new CreditCardAlreadyExistsException(String.valueOf(creditCardDTO.getCardNumber()));
        }
        CreditCard creditCard = CreditCardMapper.INSTANCE.mapCreditCard(creditCardDTO);
        creditCard = creditCardRepository.save(creditCard);
        log.info("CreditCard with CardNumber {} successfully created", creditCard.getCardNumber());
        return CreditCardMapper.INSTANCE.mapCreditCardDto(creditCard);
    }

    @Override
    public List<CreditCardDTO> listCards(String accountID) {
        log.info("Getting all creditCards for Account {}", accountID);
        return creditCardRepository.findByAccount(accountID)
                .stream()
                .map(CreditCardMapper.INSTANCE::mapCreditCardDto)
                .collect(Collectors.toList());
    }

    @Override
    public CreditCardDTO updateCard(CreditCardDTO creditCardDTO) {
        log.info("Attempt to update CreditCard with number {}", creditCardDTO.getCardNumber());
        if (!creditCardRepository.existsByCardNumber(String.valueOf(creditCardDTO.getCardNumber()))) {
            throw new CreditCardNotFoundException();
        }
        CreditCard creditCard = creditCardRepository.getById(creditCardDTO.getCardNumber());
        creditCard.setMoneyAmount(creditCard.getMoneyAmount() + creditCardDTO.getMoneyAmount());
        creditCard = creditCardRepository.save(creditCard);
        log.info("CreditCard with number {} was successfully updated", creditCardDTO.getCardNumber());
        return CreditCardMapper.INSTANCE.mapCreditCardDto(creditCard);
    }
}
