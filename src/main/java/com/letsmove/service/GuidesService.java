package com.letsmove.service;

import com.letsmove.dao.GuidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GuidesService {
    @Autowired
    private GuidesRepository guidesRepository;
}
