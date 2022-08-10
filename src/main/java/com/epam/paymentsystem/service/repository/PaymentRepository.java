package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p.status, p.paymentDate, p.paymentSum, u.firstName, u.lastName from Payment as p join User as u on p.receiver.ID = u.ID where p.receiver.ID = ?1")
    List<Payment> findAllPaymentsByRecipientUserId(String userID);

    @Query("select p.status, p.paymentDate, p.paymentSum, u.firstName, u.lastName from Payment as p join User as u on p.sender.ID = u.ID where p.sender.ID = ?1")
    List<Payment> findAllPaymentsBySenderUserId(String userID);
}
