package com.letsmove.service;

import com.letsmove.dao.GuidesRepository;
import com.letsmove.entity.Guides;
import com.letsmove.entity.Manager;
import com.letsmove.entity.Users;
import com.letsmove.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class GuidesService {
    @Autowired
    private GuidesRepository guidesRepository;
    @Autowired
    private UserService userService;

    public Guides save(Guides guides) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.FindByLogin(auth.getName());
        guides.setUsersID(users);
        guides.setAllTour(0);
        users.setRole(Role.GUIDE);
        userService.update(users);
        return guidesRepository.save(guides);
    }
}
