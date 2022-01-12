package com.example.isharelife.service.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.PostLike;
import com.example.isharelife.service.IGeneralService;

public interface IPostLikeService extends IGeneralService<PostLike> {
    Integer countPostLikeByPostingId(Long id);
    Boolean existsByPostingIdAndOwner(Long id, Account account);
}
