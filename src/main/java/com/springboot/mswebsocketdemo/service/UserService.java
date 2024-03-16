package com.springboot.mswebsocketdemo.service;

import com.springboot.mswebsocketdemo.entity.User;

import java.util.List;

public interface UserService {

    /**
     * Saves a user in the DDBB
     * @param user the User
     */
    void saveUser(User user);

    /**
     * Disconnects a user
     * @param user the User
     */
    void disconnect(User user);

    /**
     * Finds all the users in the app
     * @return a List of Users
     */
    List<User> findUsers();

}
