package com.example.isharelife.model.post;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    private String url;
}
