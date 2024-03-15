package com.springboot.mswebsocketdemo.service;

import com.springboot.mswebsocketdemo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void disconnect(User user);

    List<User> findConnectedUsers();

}
