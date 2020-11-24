package com.griso.hexagonal.user.domain.repository;

import com.griso.hexagonal.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    <S extends User> S save(S s);
}
