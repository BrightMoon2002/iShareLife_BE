package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostingImageRepository extends JpaRepository<PostingImage,Long> {
}
