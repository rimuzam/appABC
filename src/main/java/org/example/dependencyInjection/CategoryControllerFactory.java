package org.example.dependencyInjection;

import org.example.controllers.CategoryController;
import org.example.database.AppDbContext;
import org.example.repositories.CategoryRepository;
import org.example.repositories.impl.CategoryRepositoryImpl;
import org.example.services.CategoryService;
import org.example.services.impl.CategoryServiceImpl;

public class CategoryControllerFactory {
    private AppDbContext context = new AppDbContext();
    private CategoryRepository categoryRepository = new CategoryRepositoryImpl(context);
    private CategoryService categoryService = new CategoryServiceImpl(categoryRepository);
    public CategoryController controller(){
        return new CategoryController(categoryService);
    }
}
