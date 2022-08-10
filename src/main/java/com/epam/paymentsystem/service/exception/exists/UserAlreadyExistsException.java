package com.epam.paymentsystem.service.exception.exists;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class UserAlreadyExistsException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "User is already existed!";

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
