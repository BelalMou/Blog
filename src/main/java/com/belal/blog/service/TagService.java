package com.belal.blog.service;

import com.belal.blog.model.Category;
import com.belal.blog.model.Tag;

public interface TagService {

    Tag findByTitle(String title);
    Tag create(Tag tag);
    void deleteById(Long id);

}
