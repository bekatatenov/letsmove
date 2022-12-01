package com.letsmove.service;

import com.letsmove.dao.CommentsTourRepository;
import com.letsmove.entity.CommentsTour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsTourService {
    @Autowired
    private CommentsTourRepository commentsTourRepository;

    public List<CommentsTour> getAllCommentsTour(){
        return commentsTourRepository.findAll();
    }
}
