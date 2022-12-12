package com.letsmove.controller;

import com.letsmove.entity.Manager;
import com.letsmove.service.ManagerService;
import com.letsmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/manager_register", method = RequestMethod.GET)
    public ModelAndView managerRegister() {
        ModelAndView modelAndView = new ModelAndView("managerRegistration");
        modelAndView.addObject("manager", new Manager());
        return modelAndView;
    }


    @PostMapping(value = "/manager_registration")
    public String managerRegistration(@ModelAttribute(name = "manager") Manager manager) {
        this.managerService.save(manager);
        return "redirect:/login";
    }

    @RequestMapping(value = "/managerMain", method = RequestMethod.GET)
    public String managerMain() {
        return "managerMain";
    }
}
