package org.example.controllers;

import org.example.models.Category;
import org.example.services.CategoryService;

import java.util.List;

public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    public Category createCategory(Category category){
        return categoryService.createCategory(category);
    }
    public List<Category> findAllCategories(){
        return categoryService.findAllCategory();
    }
    public Category findCategoryByName(String name){
        return categoryService.findCategoryByName(name);
    }
}
