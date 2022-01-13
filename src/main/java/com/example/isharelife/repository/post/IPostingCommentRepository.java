package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.PostingComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostingCommentRepository extends JpaRepository<PostingComment,Long> {
    Iterable<PostingComment> findPostingCommentsByPostingId(Long id);

    @Query(value = "select * from posting_comment where posting_id=? limit 2", nativeQuery = true)
    Iterable<PostingComment> findPostingCommentsByPostingIdLimit(Long id);
}
