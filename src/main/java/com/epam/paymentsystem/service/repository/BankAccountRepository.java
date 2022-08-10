package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    Optional<BankAccount> findByAccountID(String id);

    List<BankAccount> findByUser(String userId);

    boolean existsByAccountID(String id);

    boolean existsByUserID(String userId);
}
