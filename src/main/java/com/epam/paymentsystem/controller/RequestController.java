package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.service.RequestService;
import com.epam.paymentsystem.service.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {
    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/request")
    public UserRequest createRequest(@RequestBody UserRequest request) {
        return requestService.createRequest(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/request")
    public List<UserRequest> listRequests() {
        return requestService.listRequests();
    }

    @DeleteMapping(value = "/request/{requestID}")
    public ResponseEntity<Void> deleteRequest(@PathVariable String requestID) {
        requestService.deleteRequest(requestID);
        return ResponseEntity.noContent().build();
    }
}
