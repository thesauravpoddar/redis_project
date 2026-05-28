package com.project.redis_project.Service.users;

import com.project.redis_project.Dto.userDto.UserDto;
import com.project.redis_project.Repositries.UserRepo;
import com.project.redis_project.Entities.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

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

        User user = User.builder()
                .name(userDto.name())
                .email(userDto.email())
                .phoneNo(userDto.phoneNo())
                .build();
        User SavedUser = userRepo.save(user);
        log.info("created user with ID: {}", SavedUser.getId() );

        return new UserDto(
                SavedUser.getName(), SavedUser.getEmail(), SavedUser.getPhoneNo()
        );

    }

    @Override
    public UserDto getUser(UUID id) {
//        if(!userRepo.existsById(id)) {
//            log.info("user with such id does not exist");
//            throw new IllegalArgumentException("no such user exists");
//        }
//            User user = userRepo.getReferenceById(id);
        User user = userRepo.findById(id)
                .orElseThrow(() -> {
                    log.error("User fetch failed. ID does not exist: {}", id);
                    return new IllegalArgumentException("No such user exists");
                });
        return new UserDto(user.getName(), user.getEmail(), user.getPhoneNo());

    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto userDto, UUID id) {
        log.info("updating the use with email: {}", userDto.email());
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user exists"));

        user.setName(userDto.name());
        User savedUser = userRepo.save(user);
        log.info("update the user with new user name");
        return new UserDto(savedUser.getName(), savedUser.getEmail(), savedUser.getPhoneNo());
    }

    @Transactional
    @Override
    public void deleteuser(UUID id) {
        User user = userRepo.findById(id)
                .orElseThrow(
                        () -> {
                            log.error("cannot perform delete the operation, no such user exists with id: {}", id);
                            return new NoSuchElementException(" no such user exists");
                        }
                );

        userRepo.delete(user);

    }


}
