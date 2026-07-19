package com.belal.blog.service;

import com.belal.blog.model.Comment;
import com.belal.blog.model.Post;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByAuthor(String author);
    Comment addComment(Comment comment, Long postId);
    void deleteComment(Long id);


}
