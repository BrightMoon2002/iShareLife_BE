package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.repository.post.ICommentLikeRepository;
import com.example.isharelife.service.post.ICommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
    public void save(CommentLike commentLike) {
        commentLikeRepository.save(commentLike);
    }

    @Override
    public void remove(Long id) {
        commentLikeRepository.deleteById(id);
    }
}
