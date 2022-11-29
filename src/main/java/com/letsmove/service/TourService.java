package com.letsmove.service;

import com.letsmove.dao.GuidesRepository;
import com.letsmove.dao.TourRepository;
import com.letsmove.entity.*;
import com.letsmove.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GuidesService guidesService;

    public Tour save(Tour tour){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.FindByLogin(auth.getName());
        Guides guides = guidesService.findByUserID(user);
        tour.setGuidesID(guides);
        tour.setCreatedDate(new Date());
        tour.setStatus(Status.NEW);
        tour.setVisitors(0);
        return tourRepository.save(tour);
    }
}
