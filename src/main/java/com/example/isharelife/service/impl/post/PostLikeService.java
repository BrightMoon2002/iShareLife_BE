package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.PostLike;
import com.example.isharelife.repository.post.IPostLikeRepository;
import com.example.isharelife.service.post.IPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostLikeService implements IPostLikeService {
    @Autowired
    IPostLikeRepository postLikeRepository;

    @Override
    public Iterable<PostLike> findAll() {
        return postLikeRepository.findAll();
    }

    @Override
    public Optional<PostLike> findById(Long id) {
        return postLikeRepository.findById(id);
    }

    @Override
    public void save(PostLike postLike) {
        postLikeRepository.save(postLike);
    }

    @Override
    public void remove(Long id) {
        postLikeRepository.deleteById(id);
    }
}
