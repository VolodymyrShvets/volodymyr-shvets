package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByAccount(String accountID);

    boolean existsByCardNumber(String cardNumber);
}
