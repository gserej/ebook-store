package com.github.gserej.springbootebookstorebackend.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
class CategoryController {

    private CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/name/{categoryShortName}")
    public CategoryDto getCategoryByShortName(@PathVariable String categoryShortName) throws CategoryNotFoundException {
        return categoryService.getCategoryByShortName(categoryShortName);
    }

}

