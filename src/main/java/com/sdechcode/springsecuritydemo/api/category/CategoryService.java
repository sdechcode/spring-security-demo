package com.sdechcode.springsecuritydemo.api.category;

import com.sdechcode.springsecuritydemo.dto.category.CategoryDto;
import com.sdechcode.springsecuritydemo.entity.CategoryEntity;
import com.sdechcode.springsecuritydemo.repo.CategoryRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> findAll() {
        List<CategoryEntity> categoryEntities = this.categoryRepository.findAll();
        return this.categoryMapper.toCategoriesDto(categoryEntities);
    }

    public CategoryDto findById(Long categoryID) {
        CategoryEntity categoryEntity = this.categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ObjectNotFoundException("category", categoryID));
        return this.categoryMapper.toCategoryDto(categoryEntity);
    }

    public CategoryDto save(CategoryDto request) {
        CategoryEntity newCategory = this.categoryMapper.fromCategoryDto(request);
        CategoryEntity savedCategory = this.categoryRepository.save(newCategory);
        return this.categoryMapper.toCategoryDto(savedCategory);
    }

    public CategoryDto update(Long categoryID, CategoryDto request) {
        CategoryEntity oldCategory = this.categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ObjectNotFoundException("category", categoryID));
        oldCategory.setName(request.name());
        oldCategory.setDescription(request.description());
        CategoryEntity updatedCategory = this.categoryRepository.save(oldCategory);
        return this.categoryMapper.toCategoryDto(updatedCategory);
    }

    public void delete(Long categoryID) {
        this.categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ObjectNotFoundException("category", categoryID));
        this.categoryRepository.deleteById(categoryID);
    }

}
