package com.letsmove.controller;

import com.letsmove.entity.City;
import com.letsmove.entity.Place;
import com.letsmove.enums.PlaceType;
import com.letsmove.enums.Role;
import com.letsmove.enums.Status;
import com.letsmove.service.CityService;
import com.letsmove.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/add_place", method = RequestMethod.GET)
    public ModelAndView addPlace() {
        List<String> citiesName = cityService.allCityName();
        ModelAndView modelAndView = new ModelAndView("addPlace");
        modelAndView.addObject("place", new Place());
        modelAndView.addObject("citiesName",citiesName);
        ArrayList<PlaceType> placeTypes = new ArrayList<PlaceType>(Arrays.asList(PlaceType.values()));
        modelAndView.addObject("placeTypes",placeTypes);
        return modelAndView;
    }


    @PostMapping(value = "/save_place")
    public String savePlace(@ModelAttribute(name = "place") Place place, @RequestParam(name = "cityName") String cityName) {
        try {
            placeService.save(place,cityName);
            return "managerMain";
        } catch (Exception e) {
            return "addPlace";
        }
    }
}
