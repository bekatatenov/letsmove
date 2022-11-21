package com.letsmove.service;

import com.letsmove.dao.ManagerRepository;
import com.letsmove.entity.Manager;
import com.letsmove.entity.Users;
import com.letsmove.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserService userService;
    public Manager save(Manager manager,String login) {
        Users users = userService.FindByLogin(login);
        manager.setUsersID(users);
        users.setRole(Role.MANAGER);
        userService.update(users);
        manager.setAllPlaces(0);
        return managerRepository.save(manager);
    }
}
