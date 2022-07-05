package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.UserRequest;

import java.util.List;

public interface RequestRepository {
    UserRequest createRequest(UserRequest request);

    List<UserRequest> listRequests();

    void deleteRequest(String requestID);
}
