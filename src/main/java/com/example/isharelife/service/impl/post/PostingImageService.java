package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.PostingImage;
import com.example.isharelife.repository.post.IPostingImageRepository;
import com.example.isharelife.service.post.IPostingImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostingImageService implements IPostingImageService {
    @Autowired
    IPostingImageRepository postingImageRepository;

    @Override
    public Iterable<PostingImage> findAll() {
        return postingImageRepository.findAll();
    }

    @Override
    public Optional<PostingImage> findById(Long id) {
        return postingImageRepository.findById(id);
    }

    @Override
    public PostingImage save(PostingImage postingImage) {
        return postingImageRepository.save(postingImage);
    }

    @Override
    public void remove(Long id) {
        postingImageRepository.deleteById(id);
    }

    @Override
    public List<String> findAllByPostingId(Long id) {
        return postingImageRepository.findAllUrlByPostingId(id);
    }

    @Override
    public void deletePostingImageByPostingId(Long id) {
        postingImageRepository.deletePostingImageByPostingId(id);
    }
}
