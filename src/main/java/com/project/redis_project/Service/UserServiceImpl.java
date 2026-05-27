package com.project.redis_project.Service;

import com.project.redis_project.Dto.userDto.UserDto;
import com.project.redis_project.Repositries.UserRepo;
import com.project.redis_project.Entities.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
      log.info("creating the user with email: {}", userDto.email());

        if(userRepo.existsByEmail(userDto.email())) {
            log.info("user with this email already exists");
            throw new IllegalArgumentException("user already exists");
        }

    }

    private User DtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNo(userDto.getPhoneNo());
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPhoneNo(user.getPhoneNo());
        return userDto;
    }


}
