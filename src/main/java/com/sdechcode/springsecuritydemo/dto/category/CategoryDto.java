package com.sdechcode.springsecuritydemo.dto.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoryDto(
        Long id,
        @NotEmpty(message = "name is required.")
        String name,
        String description
) {
}
