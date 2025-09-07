package com.ecommerce.sb_ecommerce.services;

import com.ecommerce.sb_ecommerce.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    void updateCategory(Category category, Long categoryId);
}
