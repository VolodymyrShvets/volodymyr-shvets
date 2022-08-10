package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.service.RequestService;
import com.epam.paymentsystem.service.exception.exists.RequestAlreadyExistsException;
import com.epam.paymentsystem.service.exception.notfound.RequestNotFoundException;
import com.epam.paymentsystem.service.model.AccountRequest;
import com.epam.paymentsystem.service.model.Request;
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

    /*@Override
    public Request createUserRequest(UserRequest request) {
        log.info("Request with type {} for User {} successfully created",
                request.getType(), request.getRequestedSourceID());
        return requestRepository.save(request);
    }

    @Override
    public Request createAccountRequest(AccountRequest request) {
        log.info("Request with type {} for Account {} successfully created",
                request.getType(), request.getRequestedSourceID());
        return requestRepository.save(request);
    }*/

    @Override
    public Request createRequest(Request request) {
        log.info("Request with type {} for  {} successfully created",
                request.getType(), request.getRequestedSourceID());
        return requestRepository.save(request);
    }

    @Override
    public List<Request> listRequests() {
        log.info("Getting all requests");
        return requestRepository.findAll();
    }

    @Override
    public void deleteRequest(String requestID) {
        log.info("Deleting request with ID {}", requestID);
        Request request = requestRepository.findById(Long.valueOf(requestID)).orElseThrow(RequestNotFoundException::new);
        requestRepository.delete(request);
        log.info("Request with ID {} successfully deleted", requestID);
    }
}
