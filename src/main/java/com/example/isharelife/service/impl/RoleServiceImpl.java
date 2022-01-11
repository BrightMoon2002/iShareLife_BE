package com.example.isharelife.service.impl;

import com.example.isharelife.model.account.Role;
import com.example.isharelife.model.account.RoleName;
import com.example.isharelife.repository.IRoleRepository;
import com.example.isharelife.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
