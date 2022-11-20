package com.letsmove.dao;

import com.letsmove.entity.CommentsTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsTourRepository extends JpaRepository<CommentsTour,Integer> {

}
