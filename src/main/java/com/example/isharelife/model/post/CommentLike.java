package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    @ManyToOne(targetEntity = PostingComment.class)
    private PostingComment postingComment;

    public CommentLike() {
    }

    public CommentLike(Long id, Account owner, PostingComment postingComment) {
        this.id = id;
        this.owner = owner;
        this.postingComment = postingComment;
    }

    public CommentLike(Account owner, PostingComment postingComment) {
        this.owner = owner;
        this.postingComment = postingComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public PostingComment getPostingComment() {
        return postingComment;
    }

    public void setPostingComment(PostingComment postingComment) {
        this.postingComment = postingComment;
    }
}
