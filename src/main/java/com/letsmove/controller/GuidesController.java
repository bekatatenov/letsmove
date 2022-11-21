package com.letsmove.controller;

import com.letsmove.entity.Guides;
import com.letsmove.entity.Manager;
import com.letsmove.service.GuidesService;
import com.letsmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GuidesController {
    @Autowired
    private GuidesService guidesService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/guides_register", method = RequestMethod.GET)
    public ModelAndView guidesRegister() {
        ModelAndView modelAndView = new ModelAndView("guidesRegistration");
        modelAndView.addObject("guides", new Guides());
        return modelAndView;
    }


    @PostMapping(value = "/guides_registration")
    public String guidesRegistration(@ModelAttribute(name = "guides") Guides guides, @RequestParam(name = "login") String login) {
        this.guidesService.save(guides,login);
        return "hello";
    }
}
