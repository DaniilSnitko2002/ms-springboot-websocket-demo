package com.springboot.mswebsocketdemo.service.impl;

import com.springboot.mswebsocketdemo.entity.ChatMessage;
import com.springboot.mswebsocketdemo.repository.ChatMessageRepository;
import com.springboot.mswebsocketdemo.service.ChatMessageService;
import com.springboot.mswebsocketdemo.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    private final ChatRoomService chatRoomService;

    /**
     * The Constructor
     * @param chatMessageRepository the ChatMessage repository
     * @param chatRoomService the ChatRoom Service
     */
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository, ChatRoomService chatRoomService) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatRoomService = chatRoomService;
    }

    /**
     * Saves a message
     * @param chatMessage the chat message
     * @return a ChatMessage
     */
    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(); // You can create your own dedicated exception
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;

    }

    /**
     * Find a chat messages
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return a List of ChatMessage
     */
    @Override
    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
