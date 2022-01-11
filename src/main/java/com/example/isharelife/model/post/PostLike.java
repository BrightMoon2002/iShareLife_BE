package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import javafx.geometry.Pos;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;
}
