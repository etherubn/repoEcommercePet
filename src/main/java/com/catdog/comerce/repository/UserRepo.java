package com.catdog.comerce.repository;

import com.catdog.comerce.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends RepoGeneric<User,Long> {
   Optional<User> findByDni(String dni);
   Optional<User> findByEmail(String email);
   Optional<User> findByUsername(String username);
}
