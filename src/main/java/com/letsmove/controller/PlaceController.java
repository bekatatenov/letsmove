package com.letsmove.controller;

import com.letsmove.entity.City;
import com.letsmove.entity.Place;
import com.letsmove.enums.Status;
import com.letsmove.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/add_place", method = RequestMethod.GET)
    public ModelAndView addPlace() {
        ModelAndView modelAndView = new ModelAndView("addPlace");
        modelAndView.addObject("place", new Place());
        modelAndView.addObject("");
        return modelAndView;
    }


    @PostMapping(value = "/save_place")
    public String registration(@ModelAttribute(name = "place") Place place) {
        try {
            place.setStatus(Status.NEW);
            placeService.save(place);
            return "ManagerMain";
        } catch (Exception e) {
            return "addPlace";
        }
    }
}
