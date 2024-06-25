package com.sdechcode.springsecuritydemo.api.subcategory;

import com.sdechcode.springsecuritydemo.dto.subcategory.SubCategoryDto;
import com.sdechcode.springsecuritydemo.entity.SubCategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    List<SubCategoryDto> toSubCategoriesDto(List<SubCategoryEntity> subCategoryEntities);
    SubCategoryDto toSubCategoryDto(SubCategoryEntity subCategoryEntity);
    SubCategoryEntity fromSubCategoryDto(SubCategoryDto request);
}
