package com.project.redis_project.Service.users;

import com.project.redis_project.Dto.userDto.UserDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(UUID id);

    UserDto updateUser(@Valid UserDto userDto, UUID id);

    void deleteuser(UUID id);
}
