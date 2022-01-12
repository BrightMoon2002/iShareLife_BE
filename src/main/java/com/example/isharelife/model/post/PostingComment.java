package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PostingComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    private String content;

    @ManyToOne(targetEntity = StatusComment.class)
    private StatusComment statusComment;

    private Date dateOfComment;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    public PostingComment() {
    }

    public PostingComment(Long id, Posting posting, String content, StatusComment statusComment, Date dateOfComment, Account owner) {
        this.id = id;
        this.posting = posting;
        this.content = content;
        this.statusComment = statusComment;
        this.dateOfComment = dateOfComment;
        this.owner = owner;
    }

    public PostingComment(Posting posting, String content, StatusComment statusComment, Date dateOfComment, Account owner) {
        this.posting = posting;
        this.content = content;
        this.statusComment = statusComment;
        this.dateOfComment = dateOfComment;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StatusComment getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(StatusComment statusComment) {
        this.statusComment = statusComment;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public Account getOwner() {
        return owner;
    }
    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
