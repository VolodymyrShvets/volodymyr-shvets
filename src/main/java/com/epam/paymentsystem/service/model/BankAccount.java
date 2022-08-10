package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(generator = "accountNumGenerator")
    @GenericGenerator(name = "accountNumGenerator",
            parameters = @Parameter(name = "len", value = "9"),
            strategy = "com.epam.paymentsystem.service.util.NumberGenerator")
    private long accountID;

    @ManyToOne
    @JoinColumn(name = "USER_ID")//, referencedColumnName = "ID")
    private User user;
    private Status status;

    @OneToMany(mappedBy = "account")
    private List<CreditCard> cards;
}
