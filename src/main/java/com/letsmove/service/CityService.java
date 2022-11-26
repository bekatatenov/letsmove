package com.letsmove.service;

import com.letsmove.dao.CityRepository;
import com.letsmove.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CityService{
    @Autowired
    private CityRepository cityRepository;

    public City save(City city){
        city.setCreatedDate(new Date());
        return cityRepository.save(city);
    }

}
