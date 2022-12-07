package com.letsmove.controller;

import com.letsmove.config.SecurityConfiguration;
import com.letsmove.entity.*;
import com.letsmove.enums.PlaceType;
import com.letsmove.enums.Role;
import com.letsmove.enums.Status;
import com.letsmove.service.CityService;
import com.letsmove.service.CommentsPlaceService;
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
    @Autowired
    private CommentsPlaceService commentsPlaceService;

    @RequestMapping(value = "/add_place", method = RequestMethod.GET)
    public ModelAndView addPlace() {
        List<String> citiesName = cityService.allCityName();
        ModelAndView modelAndView = new ModelAndView("addPlace");
        if (authenticatedUser().getRole().equals(Role.ADMIN)) {
            ArrayList<PlaceType> placeTypes = new ArrayList<PlaceType>(Arrays.asList(PlaceType.values()));
            modelAndView.addObject("place", new Place());
            modelAndView.addObject("citiesName", citiesName);
            modelAndView.addObject("placeTypes", placeTypes);
        } else {
            ArrayList<PlaceType> placeTypes = new ArrayList<PlaceType>(Arrays.asList(PlaceType.CAFE, PlaceType.HOTEL, PlaceType.MARKET, PlaceType.SHOPPING_CENTER));
            modelAndView.addObject("place", new Place());
            modelAndView.addObject("citiesName", citiesName);
            modelAndView.addObject("placeTypes", placeTypes);
        }
        return modelAndView;
    }


    @PostMapping(value = "/save_place")
    public String savePlace(@ModelAttribute(name = "place") Place place, @RequestParam(name = "cityName") String cityName) {
        placeService.save(place, cityName);
        if (authenticatedUser().getRole().equals(Role.ADMIN)) {
            return "adminMain";
        } else {
            return "managerMain";
        }
    }

    @RequestMapping(value = "/check_place", method = RequestMethod.GET)
    public ModelAndView checkPlace() {
        ModelAndView modelAndView = new ModelAndView("checkPlace");
        ArrayList<Place> allNewPlace = (ArrayList<Place>) placeService.getAllNewPlace();
        modelAndView.addObject("allNewPlace", allNewPlace);
        ArrayList<Status> status = new ArrayList<Status>(Arrays.asList(Status.values()));
        modelAndView.addObject("statuses", status);
        return modelAndView;
    }


    @PostMapping(value = "/save_active_place")
    public String addActivePlace(@RequestParam(name = "placeId") Integer placeId, @RequestParam(name = "status") String status) {
        placeService.updatePlaceStatus(placeId, status);
        return "redirect:/check_place";

    }

    @RequestMapping(value = "/get_all_place", method = RequestMethod.GET)
    public ModelAndView getAllPlace() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.getAllActivePlace();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_hotel", method = RequestMethod.GET)
    public ModelAndView getAllHotel() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allHotel();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_cafe", method = RequestMethod.GET)
    public ModelAndView getAllCafe() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allCafe();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_market", method = RequestMethod.GET)
    public ModelAndView getAllMarket() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allMarket();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_attraction", method = RequestMethod.GET)
    public ModelAndView getAllAttraction() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allAttraction();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_shopping_center", method = RequestMethod.GET)
    public ModelAndView getAllShoppingCenter() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allShoppingCenter();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }
    @RequestMapping(value = "/get_all_state_institutions", method = RequestMethod.GET)
    public ModelAndView getAllStateInstitutions() {
        ModelAndView modelAndView = new ModelAndView("AllPlace");
        ArrayList<Place> allActivePlace = (ArrayList<Place>) placeService.allStateInstitutions();
        modelAndView.addObject("allActivePlace", allActivePlace);
        return modelAndView;
    }


    @GetMapping(value = "/look_place")
    public ModelAndView getPlace(@RequestParam(name = "placeId") Integer placeId) {
        ModelAndView modelAndView = new ModelAndView("getPlace");
        Place place = placeService.getPlaceById(placeId);
        CommentsPlace commentsPlace = new CommentsPlace();
        commentsPlace.setPlaceID(place);
        ArrayList<CommentsPlace> commentsPlaces = (ArrayList<CommentsPlace>) commentsPlaceService.getAllCommentsPlace(place);
        modelAndView.addObject("place", place);
        modelAndView.addObject("commentsPlace", commentsPlace);
        modelAndView.addObject("allComments", commentsPlaces);
        return modelAndView;
    }

    @PostMapping(value = "/change_rating")
    public String changeRating(@RequestParam(name = "placeId") Integer placeId, @RequestParam(name = "rating") Integer rating) {
        placeService.changeRating(placeId, rating);
        return "redirect:/look_place?placeId=" + placeId;
    }

    public Users authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findByLogin(authentication.getName());
        return user;
    }
}
