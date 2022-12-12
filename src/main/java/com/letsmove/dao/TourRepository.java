package com.letsmove.dao;

import com.letsmove.entity.Guides;
import com.letsmove.entity.Place;
import com.letsmove.entity.Tour;
import com.letsmove.entity.Users;
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

    @Transactional
    ArrayList<Tour> findToursByGuidesID(Guides id);

    @Transactional
    List<Tour> findToursByStatusAndGuidesID(Status status, Guides guides);

}
