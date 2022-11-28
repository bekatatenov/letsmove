package com.letsmove.letsmove.controller;

import com.letsmove.letsmove.service.CommentsPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommentsPlaceController {
    @Autowired
    private CommentsPlaceService commentsPlaceService;
}
