package com.UdemyFaisal.ecomm.service;

import com.UdemyFaisal.ecomm.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long id);

    String updateCategory(Long categoryid, Category category);
}
