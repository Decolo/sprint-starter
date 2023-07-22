package com.example.springboot.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.springboot.Entity.User;
import com.example.springboot.Service.UserService;
import com.example.springboot.common.request.RequestUser;

import jakarta.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> add(@Valid @RequestBody RequestUser user)  {
        User _user = new User();

        _user.setName(user.getName());
        _user.setEmail(user.getEmail());

        User resUser = userService.saveUser(_user);

        return ResponseEntity.ok(resUser);
        
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> get(@Valid @PathVariable Long id)  {
        

        Optional<User> resUser = userService.getUser(id);

        return ResponseEntity.ok(resUser);
    }

    @GetMapping("/users")
    public ResponseEntity<ArrayList<User>> getUsers(@Valid @RequestParam String search)  {
        ArrayList<User> userList = userService.getUsers(search);

        return ResponseEntity.ok(userList);
    }
}
