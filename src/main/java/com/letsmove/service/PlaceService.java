package com.letsmove.service;

import com.letsmove.dao.PlaceRepository;
import com.letsmove.entity.City;
import com.letsmove.entity.Manager;
import com.letsmove.entity.Place;
import com.letsmove.entity.Users;
import com.letsmove.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ManagerService managerService;

    public Place save(Place place){
        place.setCreatedDate(new Date());
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
