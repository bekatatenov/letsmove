package com.letsmove.controller;

import com.letsmove.config.SecurityConfiguration;
import com.letsmove.entity.City;
import com.letsmove.entity.Place;
import com.letsmove.entity.Users;
import com.letsmove.enums.PlaceType;
import com.letsmove.enums.Role;
import com.letsmove.enums.Status;
import com.letsmove.service.CityService;
import com.letsmove.service.PlaceService;
import com.letsmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_place", method = RequestMethod.GET)
    public ModelAndView addPlace() {
        List<String> citiesName = cityService.allCityName();
        ArrayList<PlaceType> placeTypes = new ArrayList<PlaceType>(Arrays.asList(PlaceType.values()));
        ModelAndView modelAndView = new ModelAndView("addPlace");
        modelAndView.addObject("place", new Place());
        modelAndView.addObject("citiesName", citiesName);
        modelAndView.addObject("placeTypes", placeTypes);
        return modelAndView;
    }


    @PostMapping(value = "/save_place")
    public String savePlace(@ModelAttribute(name = "place") Place place, @RequestParam(name = "cityName") String cityName) {
        placeService.save(place, cityName);
        return "managerMain";
    }

    @RequestMapping(value = "/check_place", method = RequestMethod.GET)
    public ModelAndView checkPlace() {
        ModelAndView modelAndView = new ModelAndView("checkPlace");
        ArrayList<Place> allNewPlace = (ArrayList<Place>) placeService.getAllNewPlace();
        modelAndView.addObject("allNewPlace", allNewPlace);
        ArrayList<Status> status = new ArrayList<Status>(Arrays.asList(Status.values()));
        modelAndView.addObject("statuses",status);
        return modelAndView;
    }


    @PostMapping(value = "/save_active_place")
    public String addActivePlace(@RequestParam(name = "placeId") Integer placeId, @RequestParam(name = "status") String status) {
        try {
            placeService.updatePlaceStatus(placeId, status);
            return "adminMain";
        } catch (Exception e) {
            return "addPlace";
        }
    }
}
