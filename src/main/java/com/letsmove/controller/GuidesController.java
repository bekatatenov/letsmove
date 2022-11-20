package com.letsmove.controller;

import com.letsmove.service.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class GuidesController {
    @Autowired
    private GuidesService guidesService;
}
