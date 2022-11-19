package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.Guides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuidesRepository extends JpaRepository<Guides,Integer> {

}
