package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.Status;
import lombok.Data;

import java.util.List;

@Data
public class BankAccount {
    private final long accountID;
    private long userID;
    private Status status;
    private List<CreditCard> cards;
}
