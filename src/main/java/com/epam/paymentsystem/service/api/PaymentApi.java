package com.epam.paymentsystem.service.api;

import com.epam.paymentsystem.service.model.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Payment management API")
@RequestMapping("/api/v1/payment")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
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
