package com.project.redis_project.Controller;

import com.project.redis_project.Dto.userDto.UserDto;
import com.project.redis_project.Repositries.UserRepo;
import com.project.redis_project.Service.users.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    @PostMapping("/user")
    public ResponseEntity<UserDto> CreateUser(
            @Valid @RequestBody UserDto userDto
            ) {
        UserDto createduser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createduser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody
                                              UserDto userDto, @PathVariable UUID id
                                              ) {
        UserDto updatedUser = userService.updateUser(userDto, id);

        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteuser(id);
        return ResponseEntity.noContent().build();
    }
    
}
