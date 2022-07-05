package com.epam.paymentsystem.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreditCard {
    private final long cardNumber;
    private final long accountID;
    private final int cvv2;
    private final LocalDate expirationDate;
    private double moneyAmount;
}
