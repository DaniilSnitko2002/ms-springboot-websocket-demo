package com.springboot.mswebsocketdemo.controller;

import com.springboot.mswebsocketdemo.entity.ChatMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ChatApi {

    @MessageMapping("/chat.sendMessage")
    void processMessage(@Payload ChatMessage chatMessage);

    @GetMapping("/messages/{senderId}/{recipientId}")
    ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,
                                                       @PathVariable String recipientId);
}
