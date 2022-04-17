package com.organic.controller;

import com.organic.dto.UserDTO;
import com.organic.entity.User;
import com.organic.service.impl.UserService;
import com.organic.util.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static Key key = MD5Encryptor.generateKey();

    @GetMapping
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    @GetMapping("{id}")
    public Optional<User> getById(@PathVariable int id){
        return this.userService.findUserById(id);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User u){
        return this.userService.update(u);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserDTO u){
        String username;
        String password;
        try {
            username = u.getUsername();
            password = MD5Encryptor.encrypt(u.getPassword(), key);
            return this.userService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public User register(@RequestBody User u){
        return this.userService.save(u);
    }
}
