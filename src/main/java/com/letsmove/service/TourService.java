package com.letsmove.service;

import com.letsmove.dao.GuidesRepository;
import com.letsmove.dao.TourRepository;
import com.letsmove.entity.*;
import com.letsmove.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GuidesService guidesService;

    @Autowired
    private EmailSenderService emailSenderService;

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
    public ArrayList<Tour> getAllNewTour() {
        return tourRepository.findAllByStatus(Status.NEW);
    }
    public ArrayList<Tour> getAllActiveTour() {
        return tourRepository.findAllByStatus(Status.ACTIVE);
    }
    public Tour getTourById(Integer id){
        return tourRepository.findTourById(id);
    }

    public void updateTourStatus(Integer id, String status) {
        Tour tour = tourRepository.findPlaceById(id);
        Guides guides = tour.getGuidesID();
        Users users = guides.getUsersID();
        if (status.equals("ACTIVE")) {
            tour.setStatus(Status.ACTIVE);
            emailSenderService.sendEmail(users.getEmail(),"Поздравляю, по нашим взглядам ваш тур подходит для размещения на нашем сайте. \n Поэтому вам одобренно в доступе. \n Ваш тур уже размещён на сайте :)","Фидбек на заявку");

        } else if (status.equals("UN_ACTIVE")) {
            tour.setStatus(Status.UN_ACTIVE);
            emailSenderService.sendEmail(users.getEmail(),"К сожалению, по нашим взглядам ваш тур не подходит для размещения на нашем сайте. \n Поэтому вам отказано в доступе. \n Попробуйте переделать вашу заявку и отправить повторно :)","Фидбек на заявку");
        }
        tourRepository.save(tour);
    }
}
