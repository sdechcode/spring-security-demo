package com.sdechcode.springsecuritydemo.dto.subcategory;

import jakarta.validation.constraints.NotEmpty;

public record SubCategoryDto(
        Long id,
        @NotEmpty(message = "name is required.")
        String name,
        String description
) {
}
