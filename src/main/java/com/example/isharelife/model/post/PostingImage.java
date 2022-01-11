package com.example.isharelife.model.post;

import lombok.Data;

import javax.persistence.*;

@Entity
public class PostingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    private String url;

    public PostingImage() {
    }

    public PostingImage(Long id, Posting posting, String url) {
        this.id = id;
        this.posting = posting;
        this.url = url;
    }

    public PostingImage(Posting posting, String url) {
        this.posting = posting;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
