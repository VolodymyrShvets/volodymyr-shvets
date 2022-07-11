package com.epam.paymentsystem.api;

import com.epam.paymentsystem.service.model.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Payment management API")
@RequestMapping("/api/v1/payment")
public interface PaymentApi {
    @ApiOperation("Create payment")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Payment createPayment(Payment payment);

    @ApiOperation("Get all payments")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Payment> listPayments(@RequestBody String userID);
}
