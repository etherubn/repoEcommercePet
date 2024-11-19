package com.catdog.comerce.repository;

import com.catdog.comerce.entity.Role;
import com.catdog.comerce.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepo extends RepoGeneric<Role,Long> {
    Optional<Role> findByType(RoleType type);
}
