package com.hust.doan.repository;

import com.hust.doan.model.type.ERole;
import com.hust.doan.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    List<Role> findAllByUsers(User user);

    Optional<Role> findByName(ERole name);
}
