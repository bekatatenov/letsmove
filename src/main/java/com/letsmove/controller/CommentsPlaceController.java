package com.letsmove.controller;

import com.letsmove.entity.CommentsPlace;
import com.letsmove.entity.CommentsTour;
import com.letsmove.service.CommentsPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CommentsPlaceController {
    @Autowired
    private CommentsPlaceService commentsPlaceService;

    @PostMapping(value = "/save_place_comment")
    public String savePlaceComment(@ModelAttribute(name = "commentsPlace") CommentsPlace commentsPlace, @RequestParam(name = "placeID") Integer placeID) {
        commentsPlaceService.save(commentsPlace, placeID);
        return "redirect:/look_place?placeId=" + placeID;
    }
}
