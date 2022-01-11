package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    private String content;

    private Date dateOfPosting;

    @ManyToOne(targetEntity = PostingStatusType.class)
    private PostingStatusType postingStatusType;

    public Posting() {
    }

    public Posting(Long id, Account owner, String content, Date dateOfPosting, PostingStatusType postingStatusType) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.dateOfPosting = dateOfPosting;
        this.postingStatusType = postingStatusType;
    }

    public Posting(Account owner, String content, Date dateOfPosting, PostingStatusType postingStatusType) {
        this.owner = owner;
        this.content = content;
        this.dateOfPosting = dateOfPosting;
        this.postingStatusType = postingStatusType;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(Date dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    public PostingStatusType getPostingStatusType() {
        return postingStatusType;
    }

    public void setPostingStatusType(PostingStatusType postingStatusType) {
        this.postingStatusType = postingStatusType;
    }
}
