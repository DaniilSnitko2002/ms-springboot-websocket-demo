package com.springboot.mswebsocketdemo.service;

import com.springboot.mswebsocketdemo.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    /**
     * Saves a message
     * @param chatMessage the chat message
     * @return a ChatMessage
     */
    ChatMessage save(ChatMessage chatMessage);

    /**
     * Find a chat messages
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return a List of ChatMessage
     */
    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
