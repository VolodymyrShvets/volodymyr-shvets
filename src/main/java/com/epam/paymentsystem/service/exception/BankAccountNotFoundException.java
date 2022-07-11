package com.epam.paymentsystem.service.exception;

import com.epam.paymentsystem.service.model.enums.ErrorType;

public class BankAccountNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Bank Account is not found!";

    public BankAccountNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
