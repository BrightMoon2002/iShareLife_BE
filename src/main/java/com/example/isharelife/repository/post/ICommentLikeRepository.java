package com.example.isharelife.repository.post;

import com.example.isharelife.model.post.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentLikeRepository extends JpaRepository<CommentLike,Long> {
}
