package com.sdechcode.springsecuritydemo.dto.tag;

import jakarta.validation.constraints.NotEmpty;

public record TagDto(
        Long id,
        @NotEmpty(message = "name is required.")
        String name
) {
}
