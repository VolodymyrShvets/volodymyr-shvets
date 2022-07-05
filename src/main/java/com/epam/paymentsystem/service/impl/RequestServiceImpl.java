package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.RequestService;
import com.epam.paymentsystem.service.model.UserRequest;
import com.epam.paymentsystem.service.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Override
    public UserRequest createRequest(UserRequest request) {
        log.info("createRequest with type {} for sourceID {}",
                request.getType(), request.getRequestedSourceID());
        return requestRepository.createRequest(request);
    }

    @Override
    public List<UserRequest> listRequests() {
        log.info("get all requests");
        return requestRepository.listRequests();
    }

    @Override
    public void deleteRequest(String requestID) {
        log.info("delete request with ID {}", requestID);
        requestRepository.deleteRequest(requestID);
    }
}
