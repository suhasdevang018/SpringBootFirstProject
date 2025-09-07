package com.ecommerce.sb_ecommerce.services;

import com.ecommerce.sb_ecommerce.repositories.CategoryRepository;
import com.ecommerce.sb_ecommerce.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    //List<Category> categories = new ArrayList<>();
    private long nextId = 1L;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        categoryRepository.delete(category);
        return "Category with CategoryId : " + categoryId + " deleted successfully.";
    }

    @Override
    public void updateCategory(Category category, Long categoryId) {
        Category categories = categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found to Update the Category!"));
        categories.setCategoryName(category.getCategoryName());
        categoryRepository.save(categories);
    }
}
