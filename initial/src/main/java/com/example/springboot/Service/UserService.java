package com.example.springboot.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.springboot.Entity.User;
import com.example.springboot.common.request.RequestUser;

public interface UserService {
    
    User saveUser(User user);

    Optional<User> getUser(Long id);

    ArrayList<User> getUsers(String search);
}
