package com.epam.paymentsystem.service.mapper;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import com.epam.paymentsystem.service.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditCardMapper {
    CreditCardMapper INSTANCE = Mappers.getMapper(CreditCardMapper.class);

    CreditCardDTO mapCreditCardDto(CreditCard author);

    CreditCard mapCreditCard(CreditCardDTO authorDto);
}
