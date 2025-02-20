package com.UdemyFaisal.ecomm.controller;

import com.UdemyFaisal.ecomm.model.Category;
import com.UdemyFaisal.ecomm.service.CategoryService;
import com.UdemyFaisal.ecomm.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
//        return categoryService.getAllCategories();
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
//        return "Category added successfully";
        return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/adimin/categories/{categoryid}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryid) {
        try {
            String status = categoryService.deleteCategory(categoryid);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/adimin/categories/{categoryid}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryid, @RequestBody Category category) {
        try {
            String status = categoryService.updateCategory(categoryid, category);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
