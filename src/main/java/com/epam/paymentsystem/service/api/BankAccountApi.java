package com.epam.paymentsystem.service.api;

import com.epam.paymentsystem.service.model.BankAccount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "BankAccount management API")
@RequestMapping("/api/v1/account")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface BankAccountApi {
    @ApiOperation("Get bankAccount")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{bankAccountID}")
    BankAccount getBankAccount(@PathVariable String bankAccountID);

    @ApiOperation("Create bankAccount")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    BankAccount createBankAccount(@RequestBody BankAccount bankAccount);

    @ApiOperation("Get all bankAccounts")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<BankAccount> listAccounts(@RequestBody String userID);

    @ApiOperation("Block BankAccount")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{bankAccountID}")
    BankAccount blockAccount(@PathVariable String bankAccountID);

    @ApiOperation("Unblock bankAccount")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    BankAccount unblockAccount(@RequestBody String bankAccountID);
}
