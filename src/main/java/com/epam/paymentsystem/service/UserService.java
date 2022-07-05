package com.epam.paymentsystem.service;

import com.epam.paymentsystem.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(String email);

    List<UserDTO> listUsers();

    UserDTO createUser(UserDTO userDto);

    UserDTO updateUser(String email, UserDTO userDto);

    void deleteUser(String email);
}
