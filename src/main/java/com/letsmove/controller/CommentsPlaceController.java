package com.letsmove.controller;

import com.letsmove.service.CommentsPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommentsPlaceController {
    @Autowired
    private CommentsPlaceService commentsPlaceService;
}
