package com.letsmove.dao;

import com.letsmove.entity.Manager;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    @Transactional
    Manager findByUsersID(Users usersID);
}
