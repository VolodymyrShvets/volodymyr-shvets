package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.api.PaymentApi;
import com.epam.paymentsystem.service.PaymentService;
import com.epam.paymentsystem.service.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController implements PaymentApi {
    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return service.createPayment(payment);
    }

    @Override
    public List<Payment> listPayments(@RequestBody String userID) {
        return service.listPayments(userID);
    }
}
