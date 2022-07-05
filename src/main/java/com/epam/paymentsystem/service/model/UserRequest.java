package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.RequestType;
import lombok.Data;

@Data
public class UserRequest {
    private long requestID;
    private long requestedSourceID; // UserID or AccountID
    private RequestType type;
}
