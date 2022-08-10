package com.epam.paymentsystem.service.api;

import com.epam.paymentsystem.service.model.Request;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Request management API")
@RequestMapping("/api/v1/request")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface RequestApi {
    @ApiOperation("Create request")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Request createRequest(@RequestBody Request request);

    /*@ApiOperation("Create User request")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Request createUserRequest(UserRequest request);

    @ApiOperation("Create Account request")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Request createAccountRequest(AccountRequest request);*/

    @ApiOperation("Get all requests")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Request> listRequests();

    @ApiOperation("Delete request")
    @DeleteMapping(value = "/{requestID}")
    ResponseEntity<Void> deleteRequest(@PathVariable String requestID);
}
