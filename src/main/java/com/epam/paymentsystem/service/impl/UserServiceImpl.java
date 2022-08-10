package com.epam.paymentsystem.service.impl;

import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.service.UserService;
import com.epam.paymentsystem.service.exception.exists.UserAlreadyExistsException;
import com.epam.paymentsystem.service.exception.notfound.UserNotFoundException;
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
        log.info("Finding User by email {}", email);
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        log.info("User with email {} is found", email);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public List<UserDTO> listUsers() {
        log.info("Getting all Users");
        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::mapUserDto)//this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        log.info("Creating User with email {}", userDto.getEmail());
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.save(user);
        log.info("User with email {} successfully created", user.getEmail());
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDto) {
        log.info("Updating User with email {}", email);
        User persistedUser = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        persistedUser = UserMapper.INSTANCE.populateUserWithPresentUserDtoFields(persistedUser, userDto);
        User storedUser = userRepository.save(persistedUser);
        log.info("User with email {} successfully updated", storedUser.getEmail());
        return UserMapper.INSTANCE.mapUserDto(persistedUser);
    }

    @Override
    public void deleteUser(String email) {
        log.info("Deleting User with email {}", email);
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        log.info("User with email {} successfully deleted", email);
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
