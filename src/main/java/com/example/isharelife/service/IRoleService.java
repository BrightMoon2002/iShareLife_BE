package com.example.isharelife.service;

import com.example.isharelife.model.account.Role;
import com.example.isharelife.model.account.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
