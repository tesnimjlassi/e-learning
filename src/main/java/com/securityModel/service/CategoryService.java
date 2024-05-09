package com.securityModel.service;

import com.securityModel.models.Category;

import java.util.List;

public interface CategoryService {
    Category
    createCategory(Category category);
    List<Category> allCategories();
    Category categoryById(Long id);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
