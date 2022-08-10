package com.epam.paymentsystem.service.api;

import com.epam.paymentsystem.controller.dto.CreditCardDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "CreditCard management API")
@RequestMapping("/api/v1/card")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface CreditCardApi {
    @ApiOperation("Create creditCard")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CreditCardDTO createCard(@RequestBody CreditCardDTO creditCardDTO);

    @ApiOperation("Get all creditCards for account")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CreditCardDTO> listCards(@RequestBody String accountID);
}
