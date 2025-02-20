package com.UdemyFaisal.ecomm.service;

import com.UdemyFaisal.ecomm.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long id) {
//        categories.removeIf(category -> category.getCategoryId().equals(id));
        Category category = categories.stream().filter(category1 -> category1.getCategoryId().equals(id)).findFirst().
//                orElse(null);
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        if (category != null) {
            categories.remove(category);
            return "Category deleted successfully with Category ID " + id;
        }
        return "Category not found";
    }

    @Override
    public String updateCategory(Long categoryid, Category category) {
        return "";
    }
}
