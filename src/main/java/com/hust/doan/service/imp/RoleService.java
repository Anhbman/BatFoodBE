package com.hust.doan.service.imp;

import com.hust.doan.model.type.ERole;
import com.hust.doan.model.Role;
import com.hust.doan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(ERole name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Error: Role " + name + " is not found"));
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
