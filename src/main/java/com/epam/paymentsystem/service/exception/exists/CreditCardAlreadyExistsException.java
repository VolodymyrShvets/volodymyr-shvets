package com.epam.paymentsystem.service.exception.exists;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class CreditCardAlreadyExistsException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "CreditCard already exists with CardNumber = ";

    public CreditCardAlreadyExistsException(String sourceID) {
        super(DEFAULT_MESSAGE + sourceID);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
