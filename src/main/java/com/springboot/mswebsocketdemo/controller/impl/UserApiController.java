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

    /**
     * The Constructor
     * @param userService the user Service
     */
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Saves a user in the DDBB
     * @param user the User
     */
    @Override
    public User addUser(User user) {
        userService.saveUser(user);
        return user;
    }

    /**
     * Disconnects a user
     * @param user the User
     */
    @Override
    public User disconnectUser(User user) {
        userService.disconnect(user);
        return user;
    }

    /**
     * Finds all the users in the app
     * @return a List of Users
     */
    @Override
    public ResponseEntity<List<User>> findUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }
}
