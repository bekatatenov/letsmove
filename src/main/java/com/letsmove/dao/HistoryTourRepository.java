package com.letsmove.dao;

import com.letsmove.entity.HistoryTour;
import com.letsmove.entity.Tour;
import com.letsmove.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface HistoryTourRepository extends JpaRepository<HistoryTour,Integer> {
@Transactional
List<HistoryTour> findHistoryToursByUsersID(Users users);
@Transactional
List<HistoryTour> findHistoryToursByTourID(Tour tour);

}
