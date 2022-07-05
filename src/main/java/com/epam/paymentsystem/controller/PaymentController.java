package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.service.PaymentService;
import com.epam.paymentsystem.service.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/payment")
    public Payment createPayment(Payment payment) {
        return service.createPayment(payment);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/payment")
    public List<Payment> listPayments(@RequestBody String userID) {
        return service.listPayments(userID);
    }
}
