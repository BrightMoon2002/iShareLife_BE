package com.example.isharelife.service.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.service.IGeneralService;

import java.util.Optional;

public interface ICommentLikeService extends IGeneralService<CommentLike> {
    Integer countCommentLikeByPostingCommentId(Long id);
    Boolean existsByPostingCommentIdAndOwner(Long id, Account account);
    Optional<CommentLike> findCommentLikeByPostingCommentIdAndOwnerId(Long cId, Long accId);
}
