package com.project.redis_project.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Username", unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "UserEmail", nullable = false)
    private String email;

    @Column(name = "Phone_Number", nullable = false)
    private String phoneNo;

    @DateTimeFormat
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private String updatedAt;
}
