package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.Payment;

import java.util.List;

public interface PaymentRepository {
    Payment createPayment(Payment payment);

    List<Payment> listPayments(String userID);
}
