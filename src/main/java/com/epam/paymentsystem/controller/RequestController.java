package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.service.api.RequestApi;
import com.epam.paymentsystem.service.RequestService;
import com.epam.paymentsystem.service.model.Request;
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
    public Request createRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    /*@Override
    public Request createRequest(Request request) {
        return request;
    }*/

    /*@Override
    public Request createUserRequest(UserRequest request) {
        return requestService.createUserRequest(request);
    }

    @Override
    public Request createAccountRequest(AccountRequest request) {
        return requestService.createAccountRequest(request);
    }*/

    @Override
    public List<Request> listRequests() {
        return requestService.listRequests();
    }

    @Override
    public ResponseEntity<Void> deleteRequest(@PathVariable String requestID) {
        requestService.deleteRequest(requestID);
        return ResponseEntity.noContent().build();
    }
}
