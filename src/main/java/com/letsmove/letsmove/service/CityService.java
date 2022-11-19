package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService{
    @Autowired
    private CityRepository cityRepository;

}
