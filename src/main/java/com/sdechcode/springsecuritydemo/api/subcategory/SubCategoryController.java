package com.sdechcode.springsecuritydemo.api.subcategory;

import com.sdechcode.springsecuritydemo.dto.subcategory.SubCategoryDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/subcategories")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping(value = "")
    public Result findAllSubCategories() {
        List<SubCategoryDto> subCategories = this.subCategoryService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", subCategories);
    }

    @GetMapping(value = "/{subCategoryID}")
    public Result findSubCategoryByID(@PathVariable(name = "subCategoryID") Long subCategoryID) {
        SubCategoryDto subCategory = this.subCategoryService.findById(subCategoryID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", subCategory);
    }

    @PostMapping(value = "")
    public Result addSubCategory(@Valid @RequestBody SubCategoryDto request) {
        SubCategoryDto subCategoryDto = this.subCategoryService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", subCategoryDto);
    }

    @PutMapping(value = "/{subCategoryID}")
    public Result updateSubCategory(@PathVariable(name = "subCategoryID") Long subCategoryID, @Valid @RequestBody SubCategoryDto request) {
        SubCategoryDto subCategoryDto = this.subCategoryService.update(subCategoryID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", subCategoryDto);
    }

    @DeleteMapping(value = "/{subCategoryID}")
    public Result deleteSubCategory(@PathVariable(name = "subCategoryID") Long subCategoryID) {
        this.subCategoryService.delete(subCategoryID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
