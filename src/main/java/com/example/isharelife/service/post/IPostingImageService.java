package com.example.isharelife.service.post;

import com.example.isharelife.model.post.PostingImage;
import com.example.isharelife.service.IGeneralService;

import java.util.List;

public interface IPostingImageService extends IGeneralService<PostingImage> {
    List<String> findAllByPostingId(Long id);
}
