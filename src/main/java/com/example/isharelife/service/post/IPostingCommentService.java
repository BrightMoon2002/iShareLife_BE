package com.example.isharelife.service.post;

import com.example.isharelife.model.post.PostingComment;
import com.example.isharelife.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

public interface IPostingCommentService extends IGeneralService<PostingComment> {
    Iterable<PostingComment> findPostingCommentsByPostingId(Long id);
    Iterable<PostingComment> findPostingCommentsByPostingIdLimit(Long id);
}
