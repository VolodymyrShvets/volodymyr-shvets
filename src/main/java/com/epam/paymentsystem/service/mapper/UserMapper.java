package com.epam.paymentsystem.service.mapper;

import com.epam.paymentsystem.controller.dto.UserDTO;
import com.epam.paymentsystem.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapUserDto(User author);

    User mapUser(UserDTO authorDto);
}
