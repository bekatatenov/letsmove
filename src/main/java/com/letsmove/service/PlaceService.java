package com.letsmove.service;

import com.letsmove.dao.PlaceRepository;
import com.letsmove.entity.City;
import com.letsmove.entity.Manager;
import com.letsmove.entity.Place;
import com.letsmove.entity.Users;
import com.letsmove.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    public Place save(Place place,String cityName){
        City city = cityService.findByName(cityName);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.FindByLogin(auth.getName());
        place.setUsersID(user);
        place.setCityID(city);
        place.setCreatedDate(new Date());
        place.setStatus(Status.NEW);
        return placeRepository.save(place);
    }
/*
    public Place activatePlace(Integer placeId, Integer managerId){
        Place place = placeRepository.findById(placeId).orElseThrow(() -> new UsernameNotFoundException(""));
        place.setStatus(Status.ACTIVE);
        Manager manager = managerService.findById(managerId).orElseThrow(() -> new UsernameNotFoundException(""));
        place.setUsersID(manager.getUsersID());
    }*/
}
