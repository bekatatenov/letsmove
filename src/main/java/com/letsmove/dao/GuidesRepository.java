package com.letsmove.dao;

import com.letsmove.entity.Guides;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuidesRepository extends JpaRepository<Guides,Integer> {
    Guides findByUsersID(Users users);
}
