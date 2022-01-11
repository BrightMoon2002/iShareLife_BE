package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    @ManyToOne(targetEntity = Account.class)
    private Account account;
}
