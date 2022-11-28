package com.letsmove.dao;

import com.letsmove.entity.Token;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Object> findByTokenAndUsers(Integer token, Users users);

    Optional<Object> findByToken(Integer token);
}
