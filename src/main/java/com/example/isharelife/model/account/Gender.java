package com.example.isharelife.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    @OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Account> accounts;

    public Gender(Long id, String gender, List<Account> accounts) {
        this.id = id;
        this.gender = gender;
        this.accounts = accounts;
    }

    public Gender() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
