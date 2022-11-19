package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;
}
