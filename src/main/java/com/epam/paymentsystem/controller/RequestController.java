package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.api.RequestApi;
import com.epam.paymentsystem.service.RequestService;
import com.epam.paymentsystem.service.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController implements RequestApi {
    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public UserRequest createRequest(@RequestBody UserRequest request) {
        return requestService.createRequest(request);
    }

    @Override
    public List<UserRequest> listRequests() {
        return requestService.listRequests();
    }

    @Override
    public ResponseEntity<Void> deleteRequest(@PathVariable String requestID) {
        requestService.deleteRequest(requestID);
        return ResponseEntity.noContent().build();
    }
}
