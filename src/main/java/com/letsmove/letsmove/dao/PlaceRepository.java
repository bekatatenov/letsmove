package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {

}
