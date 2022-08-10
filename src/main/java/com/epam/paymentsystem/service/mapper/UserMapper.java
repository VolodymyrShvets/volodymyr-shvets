package com.epam.paymentsystem.service.mapper;

import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapUserDto(User user);

    User mapUser(UserDTO userDto);

    User populateUserWithPresentUserDtoFields(@MappingTarget User persistedUser, UserDTO userDto);
}
