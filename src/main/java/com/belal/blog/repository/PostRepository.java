package com.belal.blog.repository;

import com.belal.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategories_Title(String title);
    List<Post> findByTags_Title(String title);
}
