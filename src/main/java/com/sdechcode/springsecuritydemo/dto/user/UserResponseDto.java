package com.sdechcode.springsecuritydemo.dto.user;

public record UserResponseDto(
        Long id,
        String username,
        Boolean enabled,
        String roles
) {
}
