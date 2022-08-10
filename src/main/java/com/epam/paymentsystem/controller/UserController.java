package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.service.api.UserApi;
import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.controller.dto.group.OnCreate;
import com.epam.paymentsystem.controller.dto.group.OnUpdate;
import com.epam.paymentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.listUsers();
    }

    @Override
    public UserDTO getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @Override
    public UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public UserDTO updateUser(@PathVariable String email,
                              @RequestBody @Validated(OnUpdate.class) UserDTO userDto) {
        return userService.updateUser(email, userDto);
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
