package com.letsmove.service;

import com.letsmove.dao.HistoryTourRepository;
import com.letsmove.entity.Guides;
import com.letsmove.entity.HistoryTour;
import com.letsmove.entity.Tour;
import com.letsmove.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class HistoryTourService {
    @Autowired
    private HistoryTourRepository historyTourRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private GuidesService guidesService;
    @Autowired
    private TourService tourService;

    public HistoryTour save(Users userId, Tour tourId) {
        HistoryTour historyTour = new HistoryTour();
        historyTour.setTourID(tourId);
        historyTour.setUsersID(userId);
        historyTour.setCreatedDate(new Date());
        return historyTourRepository.save(historyTour);
    }

    public List<HistoryTour> historyToursForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.findByLogin(authentication.getName());
        return historyTourRepository.findHistoryToursByUsersID(users);
    }

    public List<HistoryTour> historyToursForGuide() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.findByLogin(authentication.getName());
        Guides guides = guidesService.findByUserID(users);
        ArrayList<Tour> allGuideTours = (ArrayList<Tour>) tourService.findAllToursByGuidesId(guides);
        ArrayList<HistoryTour> historyToursForGuide = new ArrayList<>();
        for (Tour tour : allGuideTours) {
            historyToursForGuide.addAll(historyTourRepository.findHistoryToursByTourID(tour));
        }
        return historyToursForGuide;
    }
}
