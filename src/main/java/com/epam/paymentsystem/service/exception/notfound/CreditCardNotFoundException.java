package com.epam.paymentsystem.service.exception.notfound;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class CreditCardNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "User is not found!";

    public CreditCardNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}