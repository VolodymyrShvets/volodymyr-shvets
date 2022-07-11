package com.epam.paymentsystem.controller.dto;

import com.epam.paymentsystem.controller.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDTO {

    @NotBlank(message = "'cardNumber' shouldn't be empty", groups = OnCreate.class)
    private final long cardNumber;

    @NotBlank(message = "'accountID' shouldn't be empty", groups = OnCreate.class)
    private final long accountID;

    @NotBlank(message = "'expirationDate' shouldn't be empty", groups = OnCreate.class)
    private final LocalDate expirationDate;

    @NotBlank(message = "'moneyAmount' shouldn't be empty", groups = OnCreate.class)
    private double moneyAmount;
}
