package com.example.isharelife.service.impl;

import com.example.isharelife.dto.request.SignInForm;
import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.oauth.Provider;
import com.example.isharelife.repository.IAccountRepository;
import com.example.isharelife.security.jwt.JwtProvider;
import com.example.isharelife.security.userprincipal.AccountPrinciple;
import com.example.isharelife.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;


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

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public Iterable<Account> findAccountsByNameContaining(String name) {
        return accountRepository.findAccountsByNameContaining(name);
    }

    public void processOAuthPostLogin(String name, String email, String password) {
        Account existUser = accountRepository.getUserByUsername(email);
        Account existEmail = accountRepository.getEmailByEmail(email);

        if (existUser == null && existEmail == null) {
            Account newUser = new Account();
            newUser.setUsername(email);
            newUser.setEmail(email);
            newUser.setName(name);
            String avatar = "https://firebasestorage.googleapis.com/v0/b/chinhbeo-18d3b.appspot.com/o/avatar.png?alt=media&token=3511cf81-8df2-4483-82a8-17becfd03211";
            newUser.setAvatar(avatar);
            newUser.setPassword(password);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);
            accountRepository.save(newUser);
        }
//        SignInForm signInForm = new SignInForm(email, email);
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(signInForm.getUsername(),
//                        signInForm.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);

    }
}
