package com.epam.paymentsystem.service.exception.exists;

import com.epam.paymentsystem.service.exception.ServiceException;
import com.epam.paymentsystem.service.model.enums.ErrorType;

public class BanAccountAlreadyExistedWithIdException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Bank Account already exists with ID = ";

    public BanAccountAlreadyExistedWithIdException(long ID) {
        super(DEFAULT_MESSAGE + ID);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
