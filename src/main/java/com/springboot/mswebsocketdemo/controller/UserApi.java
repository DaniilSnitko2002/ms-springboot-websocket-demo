package com.springboot.mswebsocketdemo.controller;

import com.springboot.mswebsocketdemo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserApi {

    /**
     * Maps incoming messages
     *
     * @param user the user
     * @return a response, which is sent to all subscribed clients listening
     */
    @MessageMapping("/user.addUser")
    @SendTo("/user/topic/public")
    User addUser(@Payload User user);

    /**
     * Maps incoming messages
     *
     * @param user the user
     * @return a response, which is sent to all subscribed clients listening
     */
    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic/public")
    User disconnectUser(@Payload User user);

    /**
     * Gets all the users
     * @return a list with all the users
     */
    @GetMapping("/users")
    ResponseEntity<List<User>> findUsers();

}
