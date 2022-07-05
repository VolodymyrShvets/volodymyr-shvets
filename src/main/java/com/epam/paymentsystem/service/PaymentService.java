package com.epam.paymentsystem.service;

import com.epam.paymentsystem.service.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);

    List<Payment> listPayments(String userID);
}
