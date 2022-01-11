package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostingStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostingStatusTypeRepository extends JpaRepository<PostingStatusType,Long> {
}
