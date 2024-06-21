package com.sdechcode.springsecuritydemo.dto.template;

public record TemplateResponseDto(
        Long id,
        String name,
        String description,
        String jsonData,
        String file
) {
}
