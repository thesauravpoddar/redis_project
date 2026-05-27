package com.project.redis_project.Service;

import com.project.redis_project.Dto.userDto.UserDto;
import com.project.redis_project.Entities.User;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
