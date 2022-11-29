package com.letsmove.dao;

import com.letsmove.entity.Place;
import com.letsmove.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findAllByStatus(Status status);
    Place findPlaceById(Integer id);
}
