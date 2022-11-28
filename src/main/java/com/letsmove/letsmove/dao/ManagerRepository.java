package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

}
