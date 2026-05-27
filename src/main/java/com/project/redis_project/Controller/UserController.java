package com.project.redis_project.Controller;

import com.project.redis_project.Dto.userDto.UserDto;
import com.project.redis_project.Repositries.UserRepo;
import com.project.redis_project.Service.UserService;
import com.project.redis_project.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    @PostMapping("/user")
    public User CreateUser(
            @RequestAttribute UserDto userDto) {
        return userService.createUser(userDto);
    }
}
