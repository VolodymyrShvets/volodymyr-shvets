package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Status status;
    private UserRole userRole;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String userPassword;
    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts;
}
