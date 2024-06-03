package com.sdechcode.springsecuritydemo.dto.user;

import jakarta.validation.constraints.NotEmpty;

public record UserRequestDto(
        @NotEmpty(message = "username is required.")
        String username,
        @NotEmpty(message = "password is required.")
        String password,
        Boolean enabled,
        String roles
) {
}
