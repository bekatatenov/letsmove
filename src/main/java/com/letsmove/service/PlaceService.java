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

    public void save(Place place,String cityName){
        City city = cityService.findByName(cityName);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.FindByLogin(auth.getName());
        place.setUsersID(user);
        place.setCityID(city);
        place.setCreatedDate(new Date());
        place.setStatus(Status.NEW);
        placeRepository.save(place);
    }
    public List<Place> getAllNewPlace(){
        return placeRepository.findAllByStatus(Status.NEW);
    }
    public void updatePlaceStatus(Integer id,String status){
        Place place = placeRepository.findPlaceById(id);
        if(status.equals("ACTIVE")){
            place.setStatus(Status.ACTIVE);
        }else if(status.equals("UN_ACTIVE")){
            place.setStatus(Status.UN_ACTIVE);
        }
        placeRepository.save(place);
    }
}
