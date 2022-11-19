package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.CommentsPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsPlaceRepository extends JpaRepository<CommentsPlace,Integer> {
}
