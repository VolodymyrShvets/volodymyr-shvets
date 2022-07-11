package com.epam.paymentsystem.api;

import com.epam.paymentsystem.service.model.UserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Request management API")
@RequestMapping("/api/v1/request")
public interface RequestApi {
    @ApiOperation("Create request")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserRequest createRequest(@RequestBody UserRequest request);

    @ApiOperation("Get all requests")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserRequest> listRequests();

    @ApiOperation("Delete request")
    @DeleteMapping(value = "/{requestID}")
    ResponseEntity<Void> deleteRequest(@PathVariable String requestID);
}
