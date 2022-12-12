package com.letsmove.dao;

import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findFirstByLogin(String login);

    Users findByEmail(String email);

    Users findByLogin(String login);
}
