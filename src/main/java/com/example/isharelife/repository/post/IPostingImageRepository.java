package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IPostingImageRepository extends JpaRepository<PostingImage,Long> {
    @Query(value = "select url from posting_image where posting_id = ?", nativeQuery = true)
    List<String> findAllUrlByPostingId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from posting_image where posting_id = ?", nativeQuery = true)
    void deletePostingImageByPostingId(Long id);
}
