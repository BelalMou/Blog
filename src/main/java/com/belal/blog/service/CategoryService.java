package com.belal.blog.service;

import com.belal.blog.model.Category;

public interface CategoryService {

    Category findByTitle(String title);
    Category create(Category category);
    void deleteById(Long id);
}
