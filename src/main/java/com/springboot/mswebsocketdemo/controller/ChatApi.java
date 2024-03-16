package com.springboot.mswebsocketdemo.controller;

import com.springboot.mswebsocketdemo.entity.ChatMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ChatApi {

    /**
     * Maps incoming messages
     * @param chatMessage the chat message
     */
    @MessageMapping("/chat.sendMessage")
    void processMessage(@Payload ChatMessage chatMessage);

    /**
     * Get the messages
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return the list of messages
     */
    @GetMapping("/messages/{senderId}/{recipientId}")
    ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,
                                                       @PathVariable String recipientId);
}
