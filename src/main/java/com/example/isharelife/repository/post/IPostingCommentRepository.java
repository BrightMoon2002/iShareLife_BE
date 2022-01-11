package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostingComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostingCommentRepository extends JpaRepository<PostingComment,Long> {
}
