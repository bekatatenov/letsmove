package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.HistoryTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoryTourRepository extends JpaRepository<HistoryTour,Integer> {
}
