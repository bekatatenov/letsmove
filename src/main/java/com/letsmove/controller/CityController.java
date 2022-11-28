package com.letsmove.controller;

import com.letsmove.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;
}
