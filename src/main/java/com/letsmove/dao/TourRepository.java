package com.letsmove.dao;

import com.letsmove.entity.Place;
import com.letsmove.entity.Tour;
import com.letsmove.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Transactional
    ArrayList<Tour> findAllByStatus(Status status);

    @Transactional
    Tour findTourById(Integer id);
}
