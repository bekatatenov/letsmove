package com.letsmove.controller;

import com.letsmove.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;
}
