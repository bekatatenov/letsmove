package com.letsmove.service;

import com.letsmove.dao.CityRepository;
import com.letsmove.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        city.setCreatedDate(new Date());
        return cityRepository.save(city);
    }

    public List<String> allCityName() {
        List<City> cities = cityRepository.findAll();
        List<String> citiesName = new ArrayList<>();
        for (City city : cities) {
            citiesName.add(city.getName());
        }
        return citiesName;
    }

    @Transactional
    public City findByName(String city) {
        return cityRepository.findCityByName(city);
    }
}
