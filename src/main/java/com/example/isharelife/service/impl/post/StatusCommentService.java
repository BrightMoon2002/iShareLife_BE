package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.StatusComment;
import com.example.isharelife.repository.post.IStatusCommentRepository;
import com.example.isharelife.service.post.IStatusCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StatusCommentService implements IStatusCommentService {

    @Autowired
    IStatusCommentRepository statusCommentRepository;

    @Override
    public Iterable<StatusComment> findAll() {
        return statusCommentRepository.findAll();
    }

    @Override
    public Optional<StatusComment> findById(Long id) {
        return statusCommentRepository.findById(id);
    }

    @Override
    public void save(StatusComment statusComment) {
        statusCommentRepository.save(statusComment);
    }

    @Override
    public void remove(Long id) {
        statusCommentRepository.deleteById(id);
    }
}
