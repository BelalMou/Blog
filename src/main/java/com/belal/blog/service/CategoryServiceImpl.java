package com.belal.blog.service;

import com.belal.blog.model.Category;
import com.belal.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByTitle(String title) {
        Optional<Category> category = categoryRepository.findByTitle(title);
        if (category.isPresent()) {
            return category.get();
        } throw new RuntimeException("Category not found");
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
        } else throw new RuntimeException("Category not found");
    }

}
