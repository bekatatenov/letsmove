package com.letsmove.dao;

import com.letsmove.entity.CommentsTour;
import com.letsmove.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface CommentsTourRepository extends JpaRepository<CommentsTour,Integer> {
    List<CommentsTour> findAllByTourID(Tour id);
}
