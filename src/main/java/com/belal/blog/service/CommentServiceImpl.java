package com.belal.blog.service;

import com.belal.blog.model.Comment;
import com.belal.blog.model.Post;
import com.belal.blog.repository.CommentRepository;
import com.belal.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    final CommentRepository commentRepository;
    final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> getCommentsByAuthor(String author){
        return commentRepository.findByAuthor(author);
    }

    @Override
    public Comment addComment(Comment comment, Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            comment.setPost(post.get());
        } else throw new RuntimeException("Post not found");
        comment.setDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            commentRepository.delete(comment.get());
        }else throw new RuntimeException("Comment not found");
    }



}
