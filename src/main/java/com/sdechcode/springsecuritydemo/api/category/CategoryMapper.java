package com.sdechcode.springsecuritydemo.api.category;

import com.sdechcode.springsecuritydemo.dto.category.CategoryDto;
import com.sdechcode.springsecuritydemo.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper { //CategoryEntity
    List<CategoryDto> toCategoriesDto(List<CategoryEntity> categoryEntities);
    CategoryDto toCategoryDto(CategoryEntity categoryEntity);
    CategoryEntity fromCategoryDto(CategoryDto categoryDto);
}
