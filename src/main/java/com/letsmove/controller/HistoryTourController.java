package com.letsmove.controller;

import com.letsmove.entity.Guides;
import com.letsmove.entity.HistoryTour;
import com.letsmove.entity.Tour;
import com.letsmove.entity.Users;
import com.letsmove.service.GuidesService;
import com.letsmove.service.HistoryTourService;
import com.letsmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HistoryTourController {
    @Autowired
    private HistoryTourService historyTourService;

    @RequestMapping(value = "/history_tour_for_user", method = RequestMethod.GET)
    public ModelAndView historyTour() {
        ArrayList<HistoryTour> userHistoryTour = (ArrayList<HistoryTour>) historyTourService.historyToursForUser();
        ModelAndView modelAndView = new ModelAndView("historyTourForUser");
        modelAndView.addObject("userHistoryTours",userHistoryTour);
        return modelAndView;
    }
    @RequestMapping(value = "/history_tour_for_guide", method = RequestMethod.GET)
    public ModelAndView historyTourForGuide() {
        ArrayList<HistoryTour> guidesHistoryTour = (ArrayList<HistoryTour>) historyTourService.historyToursForGuide();
        ModelAndView modelAndView = new ModelAndView("historyTourForGuide");
        modelAndView.addObject("guideHistoryTours",guidesHistoryTour);
        return modelAndView;
    }
}
