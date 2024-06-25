package com.sdechcode.springsecuritydemo.api.subcategory;

import com.sdechcode.springsecuritydemo.dto.subcategory.SubCategoryDto;
import com.sdechcode.springsecuritydemo.entity.SubCategoryEntity;
import com.sdechcode.springsecuritydemo.repo.SubCategoryRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;

    public List<SubCategoryDto> findAll() {
        List<SubCategoryEntity> subCategoryEntities = this.subCategoryRepository.findAll();
        return this.subCategoryMapper.toSubCategoriesDto(subCategoryEntities);
    }

    public SubCategoryDto findById(Long subCategoryId) {
        SubCategoryEntity subCategoryEntity = this.subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new ObjectNotFoundException("sub-category", subCategoryId));
        return this.subCategoryMapper.toSubCategoryDto(subCategoryEntity);
    }

    public SubCategoryDto save(SubCategoryDto request) {
        SubCategoryEntity newSubCategory = this.subCategoryMapper.fromSubCategoryDto(request);
        SubCategoryEntity savedSubCategory = this.subCategoryRepository.save(newSubCategory);
        return this.subCategoryMapper.toSubCategoryDto(savedSubCategory);
    }

    public SubCategoryDto update(Long subCategoryId, SubCategoryDto request) {
        SubCategoryEntity oldSubCategory = this.subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new ObjectNotFoundException("sub-category", subCategoryId));
        // TODO: need to use partial update later
        oldSubCategory.setName(request.name());
        oldSubCategory.setDescription(request.description());
        SubCategoryEntity updatedSubCategory = this.subCategoryRepository.save(oldSubCategory);
        return this.subCategoryMapper.toSubCategoryDto(updatedSubCategory);
    }

    public void delete(Long subCategoryId) {
        this.subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new ObjectNotFoundException("sub-category", subCategoryId));
        this.subCategoryRepository.deleteById(subCategoryId);
    }

}
