package com.letsmove.service;

import com.letsmove.dao.ManagerRepository;
import com.letsmove.entity.Manager;
import com.letsmove.entity.Place;
import com.letsmove.entity.Users;
import com.letsmove.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserService userService;

    public Manager save(Manager manager) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.FindByLogin(auth.getName());
        manager.setUsersID(users);
        users.setRole(Role.MANAGER);
        userService.update(users);
        manager.setAllPlaces(0);
        return managerRepository.save(manager);
    }

//    public Optional<Object> findById(Users usersID) {
//        managerRepository.findById(Users usersID);
//        return
//    }
}
