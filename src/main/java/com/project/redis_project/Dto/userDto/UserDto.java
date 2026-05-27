package com.project.redis_project.Dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record UserDto (

    @NotBlank(message = "name cannot be blank")
     String name,
    @NotBlank(message = "Email is required")
            @Email(message = "must be a valid email format")
    String email,

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
     String phoneNo

) {}
