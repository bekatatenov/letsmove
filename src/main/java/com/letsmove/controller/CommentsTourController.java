package com.letsmove.controller;

import com.letsmove.entity.CommentsTour;
import com.letsmove.entity.Tour;
import com.letsmove.service.CommentsTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CommentsTourController {
    @Autowired
    private CommentsTourService commentsTourService;

    @PostMapping(value = "/save_tour_comment")
    public String saveTourComment(@ModelAttribute(name = "commentsTour") CommentsTour commentsTour, @RequestParam(name = "tourID") Integer tourId) {
        commentsTourService.save(commentsTour,tourId );
        return "redirect:/book_tour?tourId="+tourId;
    }
}
