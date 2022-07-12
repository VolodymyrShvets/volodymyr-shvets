package com.epam.paymentsystem.service.mapper.impl;

import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.service.mapper.UserMapper;
import com.epam.paymentsystem.service.model.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO mapUserDto(User user) {
        if (user == null)
            throw new RuntimeException("User is Null!!!");

        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .status(user.getStatus())
                .userRole(user.getUserRole())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User mapUser(UserDTO userDto) {
        if (userDto == null)
            throw new RuntimeException("UserDTO is Null!!!");

        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .status(userDto.getStatus())
                .userRole(userDto.getUserRole())
                .email(userDto.getEmail())
                .build();
    }
}
