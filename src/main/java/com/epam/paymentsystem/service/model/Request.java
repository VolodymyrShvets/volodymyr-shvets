package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.RequestType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public abstract class Request {
    public Request() {
        this.type = RequestType.USER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long requestID;

    private final RequestType type;

    public abstract long getRequestID();

    public abstract long getRequestedSourceID();

    public abstract RequestType getType();
}
