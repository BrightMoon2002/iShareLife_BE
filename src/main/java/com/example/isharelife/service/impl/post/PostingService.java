package com.example.isharelife.service.impl.post;

import com.example.isharelife.model.post.Posting;
import com.example.isharelife.model.post.PostingImage;
import com.example.isharelife.repository.post.IPostingRepository;
import com.example.isharelife.service.post.IPostingImageService;
import com.example.isharelife.service.post.IPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostingService implements IPostingService {
    @Autowired
    IPostingRepository postingRepository;

    @Autowired
    IPostingImageService postingImageService;

    @Override
    public Iterable<Posting> findAll() {
        return postingRepository.findAll();
    }

    @Override
    public Optional<Posting> findById(Long id) {
        return postingRepository.findById(id);
    }

    @Override
    public Posting save(Posting posting) {
        postingRepository.save(posting);
        if (posting.getImages() != null) {
            List<String> imageList;
            imageList = Arrays.asList(posting.getImages().split(","));
            postingImageService.deletePostingImageByPostingId(posting.getId());
            for (String imgUrl: imageList) {
                PostingImage postingImage = new PostingImage(posting, imgUrl);
                postingImageService.save(postingImage);
            }
        }
        return posting;
    }

    @Override
    public void remove(Long id) {
        postingRepository.deleteById(id);
    }

    @Override
    public Iterable<Posting> findPostingsByContentContainsAndAndPostingStatusType(String content, Long id) {
        return postingRepository.findPostingsByContentContainingAndAndPostingStatusTypeId(content,id);
    }
}
