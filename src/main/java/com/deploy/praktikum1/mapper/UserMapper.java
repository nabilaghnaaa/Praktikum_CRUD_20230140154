package com.deploy.praktikum1.mapper;

import com.deploy.praktikum1.model.dto.UserDto;
import com.deploy.praktikum1.model.entity.User;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto toUserDtoData (User user);
}
