package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.CommentsTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CommentsTourController {
    @Autowired
    private CommentsTourService commentsTourService;
}
