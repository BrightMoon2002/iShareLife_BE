package com.example.isharelife.repository.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.model.post.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICommentLikeRepository extends JpaRepository<CommentLike,Long> {
    Integer countCommentLikeByPostingCommentId(Long id);
    Boolean existsByPostingCommentIdAndOwner(Long id, Account account);
    Optional<CommentLike> findCommentLikeByPostingCommentIdAndOwnerId(Long cId, Long accId);
}
