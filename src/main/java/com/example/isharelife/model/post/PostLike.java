package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    public PostLike() {
    }

    public PostLike(Long id, Posting posting, Account owner) {
        this.id = id;
        this.posting = posting;
        this.owner = owner;
    }

    public PostLike(Posting posting, Account owner) {
        this.posting = posting;
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

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
