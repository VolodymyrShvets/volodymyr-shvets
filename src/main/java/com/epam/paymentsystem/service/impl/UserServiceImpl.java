package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.service.UserService;
import com.epam.paymentsystem.service.mapper.UserMapper;
import com.epam.paymentsystem.service.model.User;
import com.epam.paymentsystem.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        log.info("getUser by email {}", email);
        return UserMapper.INSTANCE.mapUserDto(userRepository.getUser(email));
    }

    @Override
    public List<UserDTO> listUsers() {
        log.info("get all users");
        return userRepository.listUsers()
                .stream()
                .map(UserMapper.INSTANCE::mapUserDto)//this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = userRepository.createUser(UserMapper.INSTANCE.mapUser(userDto));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDto) {
        log.info("updateUser with email {}", email);
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        userRepository.deleteUser(email);
    }

    private UserDTO mapUserToUserDto(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .status(user.getStatus())
                .userRole(user.getUserRole())
                .email(user.getEmail())
                .build();
    }

    private User mapUserDtoToUser(UserDTO userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .status(userDto.getStatus())
                .userRole(userDto.getUserRole())
                .email(userDto.getEmail())
                .build();
    }
}
