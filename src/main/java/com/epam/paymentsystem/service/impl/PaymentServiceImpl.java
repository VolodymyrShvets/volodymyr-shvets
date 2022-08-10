package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.PaymentService;
import com.epam.paymentsystem.service.model.Payment;
import com.epam.paymentsystem.service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        log.info("Creating Payment with ID {}", payment.getPaymentID());
        payment = paymentRepository.save(payment);
        log.info("Payment with ID {} successfully created", payment.getPaymentID());
        return payment;
    }

    @Override
    public List<Payment> listPayments(String userID) {
        log.info("Getting all payments for user {}", userID);
        List<Payment> asReceiver = paymentRepository.findAllPaymentsByRecipientUserId(userID);
        List<Payment> asSender = paymentRepository.findAllPaymentsBySenderUserId(userID);
        List<Payment> summarized = Stream.concat(asReceiver.stream(), asSender.stream()).collect(Collectors.toList());
        Collections.sort(summarized, Comparator.comparing(Payment::getPaymentDate));
        return summarized;
    }
}
