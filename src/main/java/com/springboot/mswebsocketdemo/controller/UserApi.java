package com.springboot.mswebsocketdemo.controller;

import com.springboot.mswebsocketdemo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserApi {

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    User addUser(@Payload User user);

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    User disconnectUser(@Payload User user);

    @GetMapping("/users")
    ResponseEntity<List<User>> findConnectedUsers();

}
