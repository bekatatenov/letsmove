package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.CommentsPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentsPlaceService {
    @Autowired
    private CommentsPlaceRepository commentsPlaceRepository;
}
