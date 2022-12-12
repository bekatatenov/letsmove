package com.letsmove.dao;

import com.letsmove.entity.Guides;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface GuidesRepository extends JpaRepository<Guides, Integer> {
    @Transactional
    Guides findByUsersID(Users users);
}
