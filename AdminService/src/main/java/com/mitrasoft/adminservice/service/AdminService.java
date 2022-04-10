package com.mitrasoft.adminservice.service;

import com.mitrasoft.adminservice.entities.User;
import com.mitrasoft.adminservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User with this username not found");
        }
        return user;
    }
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
