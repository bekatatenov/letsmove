package com.letsmove.service;

import com.letsmove.dao.HistoryTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HistoryTourService {
    @Autowired
    private HistoryTourRepository historyTourRepository;
}
