package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.CommentsTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsTourService {
    @Autowired
    private CommentsTourRepository commentsTourRepository;
}
