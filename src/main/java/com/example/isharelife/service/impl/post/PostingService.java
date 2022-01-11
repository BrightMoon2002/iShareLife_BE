package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.Posting;
import com.example.isharelife.repository.post.IPostingRepository;
import com.example.isharelife.service.post.IPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostingService implements IPostingService {
    @Autowired
    IPostingRepository postingRepository;

    @Override
    public Iterable<Posting> findAll() {
        return postingRepository.findAll();
    }

    @Override
    public Optional<Posting> findById(Long id) {
        return postingRepository.findById(id);
    }

    @Override
    public void save(Posting posting) {
        postingRepository.save(posting);
    }

    @Override
    public void remove(Long id) {
        postingRepository.deleteById(id);
    }
}
