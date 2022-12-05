package com.letsmove.config;

import com.letsmove.entity.Users;
import com.letsmove.enums.Role;
import com.letsmove.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.findByLogin(auth.getName());
        if (users.getRole().equals(Role.USER)) {
            response.sendRedirect("/userMain");
        } else if (users.getRole().equals(Role.MANAGER)) {
            response.sendRedirect("/managerMain");
        } else if (users.getRole().equals(Role.GUIDE)) {
            response.sendRedirect("/guideMain");
        } else if (users.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/adminMain");
        }

    }
}