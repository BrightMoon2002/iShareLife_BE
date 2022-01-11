package com.example.isharelife.service.impl.post;

import com.example.isharelife.repository.post.IPostTagRepository;
import com.example.isharelife.service.post.IPostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostTag implements IPostTagService {
    @Autowired
    IPostTagRepository postTagRepository;

    @Override
    public Iterable<com.example.isharelife.model.post.PostTag> findAll() {
        return postTagRepository.findAll();
    }

    @Override
    public Optional<com.example.isharelife.model.post.PostTag> findById(Long id) {
        return postTagRepository.findById(id);
    }

    @Override
    public void save(com.example.isharelife.model.post.PostTag postTag) {
        postTagRepository.save(postTag);
    }

    @Override
    public void remove(Long id) {
        postTagRepository.deleteById(id);
    }
}
