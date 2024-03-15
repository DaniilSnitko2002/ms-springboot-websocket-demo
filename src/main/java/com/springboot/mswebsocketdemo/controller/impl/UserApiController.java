package com.springboot.mswebsocketdemo.controller.impl;

import com.springboot.mswebsocketdemo.controller.UserApi;
import com.springboot.mswebsocketdemo.entity.User;
import com.springboot.mswebsocketdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class UserApiController implements UserApi {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User addUser(User user) {
        userService.saveUser(user);
        return user;
    }

    @Override
    public User disconnectUser(User user) {
        userService.disconnect(user);
        return user;
    }

    @Override
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
