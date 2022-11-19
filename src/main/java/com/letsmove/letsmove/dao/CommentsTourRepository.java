package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.CommentsTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsTourRepository extends JpaRepository<CommentsTour,Integer> {

}
