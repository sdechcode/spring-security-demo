package com.sdechcode.springsecuritydemo.api.category;

import com.sdechcode.springsecuritydemo.dto.category.CategoryDto;
import com.sdechcode.springsecuritydemo.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        return null;
    }

    public CategoryDto findById(Long categoryID) {
        return null;
    }

    public CategoryDto save(CategoryDto request) {
        return null;
    }

    public CategoryDto update(Long categoryID, CategoryDto request) {
        return null;
    }

    public void delete(Long categoryID) {

    }

}
