package com.epam.paymentsystem.service.exception.notfound;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class RequestNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Request is not found!";

    public RequestNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
