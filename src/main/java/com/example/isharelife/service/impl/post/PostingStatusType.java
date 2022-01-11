package com.example.isharelife.service.impl.post;

import com.example.isharelife.repository.post.IPostingStatusTypeRepository;
import com.example.isharelife.service.post.IPostingStatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostingStatusType implements IPostingStatusTypeService {
    @Autowired
    IPostingStatusTypeRepository postingStatusTypeRepository;

    @Override
    public Iterable<com.example.isharelife.model.post.PostingStatusType> findAll() {
        return postingStatusTypeRepository.findAll();
    }

    @Override
    public Optional<com.example.isharelife.model.post.PostingStatusType> findById(Long id) {
        return postingStatusTypeRepository.findById(id);
    }

    @Override
    public void save(com.example.isharelife.model.post.PostingStatusType postingStatusType) {
        postingStatusTypeRepository.save(postingStatusType);
    }

    @Override
    public void remove(Long id) {
        postingStatusTypeRepository.deleteById(id);
    }
}
