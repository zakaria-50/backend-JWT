package com.project.backend.mappers;


import com.project.backend.dtos.SignUpDto;
import com.project.backend.dtos.UserDto;
import com.project.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
