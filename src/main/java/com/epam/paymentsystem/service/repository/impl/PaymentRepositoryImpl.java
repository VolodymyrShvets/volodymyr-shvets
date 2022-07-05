package com.epam.paymentsystem.service.repository.impl;

import com.epam.paymentsystem.service.model.Payment;
import com.epam.paymentsystem.service.repository.PaymentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {
    private final List<Payment> list = new ArrayList<>();

    @Override
    public Payment createPayment(Payment payment) {
        list.add(payment);
        return payment;
    }

    @Override
    public List<Payment> listPayments(String userID) {
        List<Payment> userPayments1 = list.stream().filter(payment -> String.valueOf(payment.getSenderID()).equals(userID)).collect(Collectors.toList());
        List<Payment> userPayments2 = list.stream().filter(payment -> String.valueOf(payment.getReceiverID()).equals(userID)).collect(Collectors.toList());

        return Stream.concat(userPayments1.stream(), userPayments2.stream())
                .sorted(Comparator.comparing(Payment::getPaymentDate))
                .collect(Collectors.toList());
    }
}
