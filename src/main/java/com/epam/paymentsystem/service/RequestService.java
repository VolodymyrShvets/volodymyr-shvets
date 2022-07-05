package com.epam.paymentsystem.service;

import com.epam.paymentsystem.service.model.UserRequest;

import java.util.List;

public interface RequestService {
    UserRequest createRequest(UserRequest request);

    List<UserRequest> listRequests();

    void deleteRequest(String requestID);
}
