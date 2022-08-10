package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Payment {
    @Id
    private long paymentID;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
    @ManyToOne
    @JoinColumn(name = "receiver_card_card_number")
    private CreditCard receiverCard;
    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private User receiver;
    @ManyToOne
    @JoinColumn(name = "sender_card_card_number")
    private CreditCard senderCard;
    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private User sender;
    private double paymentSum;
}
