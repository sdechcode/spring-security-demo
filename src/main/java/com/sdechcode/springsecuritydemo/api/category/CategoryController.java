package com.sdechcode.springsecuritydemo.api.category;

import com.sdechcode.springsecuritydemo.dto.category.CategoryDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value = "")
    public Result findAllCategories() {
        List<CategoryDto> categories = this.categoryService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", categories);
    }

    @GetMapping(value = "/{categoryID}")
    public Result findCategoryByID(@PathVariable(name = "categoryID") Long categoryID) {
        CategoryDto category = this.categoryService.findById(categoryID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", category);
    }

    @PostMapping(value = "")
    public Result addCategory(@Valid @RequestBody CategoryDto request) {
        CategoryDto categoryDto = this.categoryService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", categoryDto);
    }

    @PutMapping(value = "/{categoryID}")
    public Result updateCategory(@PathVariable(name = "categoryID") Long categoryID, @Valid @RequestBody CategoryDto request) {
        CategoryDto categoryDto = this.categoryService.update(categoryID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", categoryDto);
    }

    @DeleteMapping(value = "/{categoryID}")
    public Result deleteCategory(@PathVariable(name = "categoryID") Long categoryID) {
        this.categoryService.delete(categoryID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
