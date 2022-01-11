package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.PostingComment;
import com.example.isharelife.repository.post.IPostingCommentRepository;
import com.example.isharelife.service.post.IPostingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostingCommentService implements IPostingCommentService {

    @Autowired
    IPostingCommentRepository postingCommentRepository;

    @Override
    public Iterable<PostingComment> findAll() {
        return postingCommentRepository.findAll();
    }

    @Override
    public Optional<PostingComment> findById(Long id) {
        return postingCommentRepository.findById(id);
    }

    @Override
    public void save(PostingComment postingComment) {
        postingCommentRepository.save(postingComment);
    }

    @Override
    public void remove(Long id) {
        postingCommentRepository.deleteById(id);
    }
}
