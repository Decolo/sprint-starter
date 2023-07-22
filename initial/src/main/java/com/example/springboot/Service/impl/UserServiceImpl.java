package com.example.springboot.Service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entity.User;
import com.example.springboot.Service.UserRepository;
import com.example.springboot.Service.UserService;
import com.example.springboot.common.request.RequestUser;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public ArrayList<User> getUsers(String search) {
        ArrayList<User> userList = userRepository.getUsersBySearch(search);

        return userList;
    }
}
