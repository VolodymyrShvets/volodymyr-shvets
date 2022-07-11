package com.epam.paymentsystem.controller;

import com.epam.paymentsystem.api.UserApi;
import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.controller.dto.group.OnCreate;
import com.epam.paymentsystem.controller.dto.group.OnUpdate;
import com.epam.paymentsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User management API")
@RequestMapping("/api/v1/user")
@RestController
public class UserController {// implements UserApi {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.listUsers();
    }

    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDTO getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDto) {
        return userService.createUser(userDto);
    }

    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDTO updateUser(@PathVariable String email,
                              @RequestBody @Validated(OnUpdate.class) UserDTO userDto) {
        return userService.updateUser(email, userDto);
    }

    @ApiOperation("Delete user")
    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
