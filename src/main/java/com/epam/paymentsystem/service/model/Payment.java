package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {
    private long paymentID;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
    private long receiverCardNumber;
    private long receiverID;
    private String receiverName;
    private long senderCardNumber;
    private long senderID;
    private String senderName;
    private double paymentSum;
}
