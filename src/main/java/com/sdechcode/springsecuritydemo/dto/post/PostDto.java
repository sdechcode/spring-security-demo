package com.sdechcode.springsecuritydemo.dto.post;

import jakarta.validation.constraints.NotEmpty;

public record PostDto(
        Long id,
        @NotEmpty(message = "title is required.")
        String title,
        String image,
        String content
) {
}
