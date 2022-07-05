package com.epam.paymentsystem.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreditCardDTO {
    private final long cardNumber;
    private final long accountID;
    private final LocalDate expirationDate;
    private double moneyAmount;
}
