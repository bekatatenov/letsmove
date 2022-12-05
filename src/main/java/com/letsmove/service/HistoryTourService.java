package com.letsmove.service;

import com.letsmove.dao.HistoryTourRepository;
import com.letsmove.entity.HistoryTour;
import com.letsmove.entity.Tour;
import com.letsmove.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class HistoryTourService {
    @Autowired
    private HistoryTourRepository historyTourRepository;

    public HistoryTour save(Users userId, Tour tourId){
        HistoryTour historyTour = new HistoryTour();
        historyTour.setTourID(tourId);
        historyTour.setUsersID(userId);
        historyTour.setCreatedDate(new Date());
        return historyTourRepository.save(historyTour);
    }
}
