package com.epam.paymentsystem.service.repository.impl;

import com.epam.paymentsystem.service.model.Request;
import com.epam.paymentsystem.service.repository.RequestRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestRepositoryImpl {//implements RequestRepository {
    private final List<Request> list = new ArrayList<>();

    //@Override
    public Request createRequest(Request request) {
        list.add(request);
        return request;
    }

    //@Override
    public List<Request> listRequests() {
        return new ArrayList<>(list);
    }

    //@Override
    public void deleteRequest(String requestID) {
        list.removeIf(request -> String.valueOf(request.getRequestID()).equals(requestID));
    }
}
