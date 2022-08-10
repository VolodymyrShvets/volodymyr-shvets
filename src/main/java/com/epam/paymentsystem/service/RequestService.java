package com.epam.paymentsystem.service;

import com.epam.paymentsystem.service.model.AccountRequest;
import com.epam.paymentsystem.service.model.Request;
import com.epam.paymentsystem.service.model.UserRequest;

import java.util.List;

public interface RequestService {
    //Request createUserRequest(UserRequest request);

    //Request createAccountRequest(AccountRequest request);

    Request createRequest(Request request);

    List<Request> listRequests();

    void deleteRequest(String requestID);
}
