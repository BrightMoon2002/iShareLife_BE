package com.example.isharelife.service;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.service.impl.AccountServiceImpl;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String name); // tìm kiếm user có tồn tại trong DB không?
    Boolean existsByUsername(String username); // username đã có trong DB chưa, khi tạo dữ liệu
    Boolean existsByEmail(String email); //email đã có trong DB chưa
    Account save(Account account);
}
