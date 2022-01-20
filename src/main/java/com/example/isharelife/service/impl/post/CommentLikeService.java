package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.repository.post.ICommentLikeRepository;
import com.example.isharelife.service.post.ICommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentLikeService implements ICommentLikeService {

    @Autowired
    ICommentLikeRepository commentLikeRepository;

    @Override
    public Iterable<CommentLike> findAll() {
        return commentLikeRepository.findAll();
    }

    @Override
    public Optional<CommentLike> findById(Long id) {
        return commentLikeRepository.findById(id);
    }

    @Override
    public CommentLike save(CommentLike commentLike) {
        return commentLikeRepository.save(commentLike);
    }

    @Override
    public void remove(Long id) {
        commentLikeRepository.deleteById(id);
    }

    @Override
    public Integer countCommentLikeByPostingCommentId(Long id) {
        return commentLikeRepository.countCommentLikeByPostingCommentId(id);
    }

    @Override
    public Boolean existsByPostingCommentIdAndOwner(Long id, Account account) {
        return commentLikeRepository.existsByPostingCommentIdAndOwner(id, account);
    }

    @Override
    public Optional<CommentLike> findCommentLikeByPostingCommentIdAndOwnerId(Long cId, Long accId) {
        return commentLikeRepository.findCommentLikeByPostingCommentIdAndOwnerId(cId, accId);
    }
}
