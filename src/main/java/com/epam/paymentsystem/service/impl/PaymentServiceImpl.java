package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.PaymentService;
import com.epam.paymentsystem.service.model.Payment;
import com.epam.paymentsystem.service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        log.info("createPayment with ID {}", payment.getPaymentID());
        return paymentRepository.createPayment(payment);
    }

    @Override
    public List<Payment> listPayments(String userID) {
        log.info("get all payments");
        return paymentRepository.listPayments(userID);
    }
}
