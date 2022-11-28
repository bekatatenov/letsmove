package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;
}
