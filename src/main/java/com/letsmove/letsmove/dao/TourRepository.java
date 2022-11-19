package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

}
