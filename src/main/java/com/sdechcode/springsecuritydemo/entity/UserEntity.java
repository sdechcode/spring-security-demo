package com.sdechcode.springsecuritydemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "username is required.")
    @Column(nullable = false, length = 100)
    private String username;

    @NotEmpty(message = "password is required.")
    @Column(nullable = false, length = 100)
    private String password;

    private Boolean enabled;

    @NotEmpty(message = "roles are required.")
    private String roles; // Space separated string
}
