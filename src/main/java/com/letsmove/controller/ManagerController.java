package com.letsmove.controller;

import com.letsmove.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
}
