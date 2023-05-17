package com.videohub.videohub.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videohub.videohub.model.Category;
import com.videohub.videohub.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(String title, Category category) {
        Category existingCategory = categoryRepository.findByTitle(title);
        if (existingCategory != null) {
            existingCategory.setTitle(category.getTitle());
            existingCategory.setLanguage(category.getLanguage());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public boolean deleteCategory(String title) {
        Category existingCategory = categoryRepository.findByTitle(title);
        if (existingCategory != null) {
            categoryRepository.delete(existingCategory);
            return true;
        }
        return false;
    }
}
