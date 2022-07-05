package com.epam.paymentsystem.service.model;

import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.model.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long userID;
    private Status status;
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
}
