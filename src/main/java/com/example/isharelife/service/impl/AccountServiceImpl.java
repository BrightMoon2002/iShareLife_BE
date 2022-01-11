package com.example.isharelife.service.impl;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.repository.IAccountRepository;
import com.example.isharelife.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;


    @Override
    public Optional<Account> findByUsername(String name) {
        return accountRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
