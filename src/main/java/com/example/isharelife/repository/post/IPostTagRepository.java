package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostTagRepository extends JpaRepository<PostTag,Long> {
}
