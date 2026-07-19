package com.belal.blog.service;

import com.belal.blog.model.Post;
import com.belal.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else throw new RuntimeException("Post with id " + id + " not found");
    }

    @Override
    public List<Post> getPostsByCategoryTitle(String title){
        return postRepository.findByCategories_Title(title);
    }

    @Override
    public List<Post> getPostsByTagTitle(String title){
        return postRepository.findByTags_Title(title);
    }

    @Override
    public Post createPost(Post post){
        post.setDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post){
        Optional<Post> exiting = postRepository.findById(id);
        if(exiting.isPresent()){
            Post post1 = exiting.get();
            post1.setTitle(post.getTitle());
            post1.setContent(post.getContent());
            post1.setCategories(post.getCategories());
            post1.setTags(post.getTags());
            return postRepository.save(post1);
        } else throw new RuntimeException("Post with id " + id + " not found");
    }

    @Override
    public void deletePost(Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            postRepository.delete(post.get());
        } else throw new RuntimeException("Post with id " + id + " not found");
    }
}
