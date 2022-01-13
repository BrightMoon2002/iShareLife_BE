package com.example.isharelife.repository.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPostLikeRepository extends JpaRepository<PostLike,Long> {
    Integer countPostLikeByPostingId(Long id);
    Boolean existsByPostingIdAndOwner(Long id, Account account);
    Optional<PostLike> findPostLikeByPostingIdAndOwnerId(Long pId, Long accId);
}
