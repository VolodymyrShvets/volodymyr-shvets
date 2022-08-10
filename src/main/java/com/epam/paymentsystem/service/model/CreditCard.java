package com.epam.paymentsystem.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue(generator = "cardNumberGenerator")
    @GenericGenerator(name = "cardNumberGenerator",
            parameters = @Parameter(name = "len", value = "16"),
            strategy = "com.epam.paymentsystem.service.util.NumberGenerator")
    private long cardNumber;

    @ManyToOne
    @JoinColumn(name = "BANKACCOUNT_ID")//, referencedColumnName = "ID")
    private BankAccount account;

    @GeneratedValue(generator = "cvvGenerator")
    @GenericGenerator(name = "cvvGenerator",
            parameters = @Parameter(name = "len", value = "3"),
            strategy = "com.epam.paymentsystem.service.util.NumberGenerator")
    private int cvv2;
    private LocalDate expirationDate;
    private double moneyAmount;
}
