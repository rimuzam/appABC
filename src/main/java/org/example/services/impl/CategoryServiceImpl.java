package org.example.services.impl;

import org.example.exceptions.WarningException;
import org.example.models.Category;
import org.example.repositories.CategoryRepository;
import org.example.services.CategoryService;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public Category createCategory(Category category){
        Category categoryName = categoryRepository.findCategoryName(category.getName());
        if (categoryName.getId() == null){
            category.setId(UUID.randomUUID().toString());
            return categoryRepository.createCategory(category);
        }
        throw new WarningException("Gagal membuat, Kategori sudah tersedia");
    }
    public List<Category> findAllCategory(){
        return categoryRepository.findAllCategory();
    }
    public Category findCategoryByName(String categoryName){
        return categoryRepository.findCategoryName(categoryName);
    }
}
