package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.PostLike;
import com.example.isharelife.repository.post.IPostLikeRepository;
import com.example.isharelife.service.post.IPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
    public PostLike save(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    @Override
    public void remove(Long id) {
        postLikeRepository.deleteById(id);
    }

    @Override
    public Integer countPostLikeByPostingId(Long id) {
        return postLikeRepository.countPostLikeByPostingId(id);
    }

    @Override
    public Boolean existsByPostingIdAndOwner(Long id, Account account) {
        return postLikeRepository.existsByPostingIdAndOwner(id, account);
    }

    @Override
    public Optional<PostLike> findPostLikeByPostingIdAndOwnerId(Long pId, Long accId) {
        return postLikeRepository.findPostLikeByPostingIdAndOwnerId(pId, accId);
    }
}
