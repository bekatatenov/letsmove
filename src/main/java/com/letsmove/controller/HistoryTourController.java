package com.letsmove.controller;

import com.letsmove.service.HistoryTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class HistoryTourController {
    @Autowired
    private HistoryTourService historyTourService;
}
