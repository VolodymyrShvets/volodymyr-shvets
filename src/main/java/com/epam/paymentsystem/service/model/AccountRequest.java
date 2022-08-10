package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.RequestType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AccountRequest extends Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestID;
    @ManyToOne
    @JoinColumn(name = "account_account_id")
    private BankAccount account;

    @Override
    public long getRequestedSourceID() {
        return account.getAccountID();
    }

    @Override
    public long getRequestID() {
        return super.requestID;
    }

    @Override
    public RequestType getType() {
        return RequestType.ACCOUNT;
    }
}
