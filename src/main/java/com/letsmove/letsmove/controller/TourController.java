package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class TourController {
    @Autowired
    private TourService tourService;
}
