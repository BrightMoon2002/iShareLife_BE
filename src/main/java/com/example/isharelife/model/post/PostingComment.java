package com.example.isharelife.model.post;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
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


}
