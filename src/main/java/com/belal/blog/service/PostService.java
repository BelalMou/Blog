package com.belal.blog.service;

import com.belal.blog.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    Post getPostById(long id);
    List<Post> getPostsByCategoryTitle(String title);
    List<Post> getPostsByTagTitle(String title);

    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}
