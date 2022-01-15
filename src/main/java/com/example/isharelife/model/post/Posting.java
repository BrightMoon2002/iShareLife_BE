package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Lob
    private String images;

    public Posting() {
    }

    public Posting(Long id, Account owner, String content, Date dateOfPosting, PostingStatusType postingStatusType, String images) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.dateOfPosting = dateOfPosting;
        this.postingStatusType = postingStatusType;
        this.images = images;
    }

    public Posting(Account owner, String content, Date dateOfPosting, PostingStatusType postingStatusType, String images) {
        this.owner = owner;
        this.content = content;
        this.dateOfPosting = dateOfPosting;
        this.postingStatusType = postingStatusType;
        this.images = images;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
