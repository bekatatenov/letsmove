package com.letsmove.letsmove.service;

import com.letsmove.letsmove.dao.UserRepository;
import com.letsmove.letsmove.entity.Users;
import com.letsmove.letsmove.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    public Users save(Users user) {
        user.setRole(Role.USER);
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Users user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new User(user.getEmail(), user.getPassword(), authorities);
    }

}