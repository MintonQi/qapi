package com.minton.qapi.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minton.qapi.common.aop.AdminCheck;
import com.minton.qapi.user.model.User;
import com.minton.qapi.user.request.UserRequest;
import com.minton.qapi.user.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    @AdminCheck
    public User createUser(@RequestBody UserRequest userRequest) {
        User user = userRequest.getUser();
        userService.register(user);
        return user;
    }

    @GetMapping
    @AdminCheck
    public List<User> getAllUsers() {
        return userService.list();
    }

    @GetMapping("/{id}")
    @AdminCheck
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @AdminCheck
    public User updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userRequest.getUser();
        user.setId(id);
        userService.updateById(user);
        return user;
    }

    @DeleteMapping("/{id}")
    @AdminCheck
    public void deleteUser(@PathVariable Long id) {
        userService.removeById(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequest userRequest) {
        userService.register(userRequest.getUser());
    }

    @PostMapping("/login")
    public void login(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        userService.login(userRequest.getUser().getUsername(), userRequest.getUser().getUserpassword(), request);
    }   
}
