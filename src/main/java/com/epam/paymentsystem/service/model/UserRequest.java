package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.RequestType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRequest extends Request {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public long getRequestID() {
        return super.requestID;
    }

    @Override
    public long getRequestedSourceID() {
        return user.getID();
    }

    @Override
    public RequestType getType() {
        return RequestType.USER;
    }
}
