package com.epam.paymentsystem.controller.dto;

import com.epam.paymentsystem.controller.dto.group.OnCreate;
import com.epam.paymentsystem.controller.validation.CardNumber;
import com.epam.paymentsystem.service.model.BankAccount;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDTO {

    @CardNumber
    //@NotBlank(message = "'cardNumber' shouldn't be empty", groups = OnCreate.class)
    private final long cardNumber;

    //@NotBlank(message = "'account' shouldn't be empty", groups = OnCreate.class)
    private final BankAccount account;

    //@NotBlank(message = "'expirationDate' shouldn't be empty", groups = OnCreate.class)
    private final LocalDate expirationDate;

    //@NotBlank(message = "'moneyAmount' shouldn't be empty", groups = OnCreate.class)
    private double moneyAmount;
}
