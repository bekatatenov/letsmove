package com.letsmove.controller;

import com.letsmove.entity.Place;
import com.letsmove.entity.Tour;
import com.letsmove.enums.PlaceType;
import com.letsmove.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class TourController {
    @Autowired
    private TourService tourService;

    @RequestMapping(value = "/add_tour", method = RequestMethod.GET)
    public ModelAndView addTour() {
        ModelAndView modelAndView = new ModelAndView("addTour");
        modelAndView.addObject("tour", new Tour());
        return modelAndView;
    }


    @PostMapping(value = "/save_tour")
    public String saveTour(@ModelAttribute(name = "tour") Tour tour) {
        try {
            tourService.save(tour);
            return "guideMain";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "addTour";
        }
    }
}
