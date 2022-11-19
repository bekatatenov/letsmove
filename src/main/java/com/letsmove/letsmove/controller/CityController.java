package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;
}
