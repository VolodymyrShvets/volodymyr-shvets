package com.epam.paymentsystem.controller.dto;

import com.epam.paymentsystem.controller.dto.group.OnCreate;
import com.epam.paymentsystem.controller.dto.group.OnUpdate;
import com.epam.paymentsystem.service.model.enums.Status;
import com.epam.paymentsystem.service.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotNull(message = "'id' shouldn't be empty", groups = OnCreate.class)
    private long userID;

    @NotNull(message = "'status' shouldn't be empty", groups = OnCreate.class)
    private Status status;

    @NotNull(message = "'userRole' shouldn't be empty", groups = OnCreate.class)
    private UserRole userRole;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @Email
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'email' shouldn't be empty", groups = OnCreate.class)
    private String email;
}
