package com.epam.paymentsystem.service.exception.exists;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class RequestAlreadyExistsException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Request already exists for sourceID = ";

    public RequestAlreadyExistsException(String sourceID) {
        super(DEFAULT_MESSAGE + sourceID);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
