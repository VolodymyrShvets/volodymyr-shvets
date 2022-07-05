package com.epam.paymentsystem.controller.dto;

import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.model.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private long userID;
    private Status status;
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private String email;
}
