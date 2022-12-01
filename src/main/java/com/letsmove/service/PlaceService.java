package com.letsmove.service;

import com.letsmove.dao.PlaceRepository;
import com.letsmove.entity.City;
import com.letsmove.entity.Place;
import com.letsmove.entity.Users;
import com.letsmove.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    public void save(Place place, String cityName) {
        City city = cityService.findByName(cityName);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.FindByLogin(auth.getName());
        place.setUsersID(user);
        place.setCityID(city);
        place.setCreatedDate(new Date());
        place.setStatus(Status.NEW);
        placeRepository.save(place);
    }

    public List<Place> getAllNewPlace() {
        return placeRepository.findAllByStatus(Status.NEW);
    }

    public void updatePlaceStatus(Integer id, String status) {
        Place place = placeRepository.findPlaceById(id);
        Users users = place.getUsersID();
        if (status.equals("ACTIVE")) {
            place.setStatus(Status.ACTIVE);
            emailSenderService.sendEmail(users.getEmail(),"Поздравляю, по нашим взглядам ваше заведение подходит для размещения на нашем сайте. \n Поэтому вам одобренно в доступе. \n Ваше заведение уже размещено на сайте :)","Фидбек на заявку");

        } else if (status.equals("UN_ACTIVE")) {
            place.setStatus(Status.UN_ACTIVE);
            emailSenderService.sendEmail(users.getEmail(),"К сожалению, по нашим взглядам ваше заведение не подходит для размещения на нашем сайте. \n Поэтому вам отказано в доступе. \n Попробуйте переделать вашу заявку и отправить повторно :)","Фидбек на заявку");

        }
        placeRepository.save(place);
    }
}
