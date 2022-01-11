package com.example.isharelife.repository;

import com.example.isharelife.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> { Optional<Account> findByUsername(String name);// tìm kiếm user có tồn tại trong DB không?
    Boolean existsByUsername(String username);// username đã có trong DB chưa, khi tạo dữ liệu
    Boolean existsByEmail(String email);// email đã có trong DB chưa
    Account save(Account account);
}
