package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.HistoryTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class HistoryTourController {
    @Autowired
    private HistoryTourService historyTourService;
}
