package com.letsmove.dao;

import com.letsmove.entity.CommentsPlace;
import com.letsmove.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CommentsPlaceRepository extends JpaRepository<CommentsPlace, Integer> {
    @Transactional
    List<CommentsPlace> findCommentsPlacesByPlaceID(Place id);
}
