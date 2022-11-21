package com.letsmove.controller;

import com.letsmove.entity.Users;
import com.letsmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Почта или пароль неверны");
            model.setViewName("/login");
        }
        if (logout != null) {
            model.addObject("logout", "Logged out successfully.");
            model.setViewName("/login");
        }
        return model;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new Users());
        return modelAndView;
    }


    @PostMapping(value = "/registration")
    public String registration(@RequestParam(value = "error", required = false) String error,@ModelAttribute(name = "user") Users user) {
        Users users = userService.FindByLogin(user.getLogin());
        if(users!=null){
            ModelAndView model = new ModelAndView();
            model.addObject("error", "Login busy");
            model.setViewName("/register");
        }else {
            this.userService.save(user);
        }
        return "hello";
    }
}
