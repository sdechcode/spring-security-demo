package com.sdechcode.springsecuritydemo.dto.template;

import jakarta.validation.constraints.NotEmpty;

public record TemplateRequestDto(
        @NotEmpty(message = "name is required.")
        String name,
        String description,
        Object jsonData,
        String file
) {
}
