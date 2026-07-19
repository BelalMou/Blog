package com.belal.blog.service;

import com.belal.blog.model.Tag;
import com.belal.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag findByTitle(String title){
        Optional<Tag> tag = tagRepository.findByTitle(title);
        if (tag.isPresent()){
            return tag.get();
        } throw new RuntimeException("Tag Not Found");
    }

    @Override
    public Tag create(Tag tag){
        return tagRepository.save(tag);
    }

    public void deleteById(Long id){
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isPresent()){
            tagRepository.delete(tag.get());
        }else throw new RuntimeException("Tag Not Found");
    }




}
