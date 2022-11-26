package com.letsmove.dao;

import com.letsmove.entity.Manager;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    Manager findById(Manager usersID);
}
