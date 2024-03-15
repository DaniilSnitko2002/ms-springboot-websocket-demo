package com.springboot.mswebsocketdemo.service;

import com.springboot.mswebsocketdemo.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
