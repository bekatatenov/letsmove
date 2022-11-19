package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class GuidesController {
    @Autowired
    private GuidesService guidesService;
}
