package org.example.services;

import org.example.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> findAllCategory();
    Category findCategoryByName(String categoryName);
}
