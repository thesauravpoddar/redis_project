package com.project.redis_project.Repositries;

import com.project.redis_project.Entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "must be a valid email format") String email);
}
