package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
}
