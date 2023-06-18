package org.example.repositories;

import org.example.models.Category;

import java.util.List;

public interface CategoryRepository {
    Category createCategory(Category category);
    Category findCategoryName(String name);
    List<Category> findAllCategory();
}
