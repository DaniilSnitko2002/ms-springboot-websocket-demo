package com.springboot.mswebsocketdemo.controller.impl;

import com.springboot.mswebsocketdemo.controller.ChatApi;
import com.springboot.mswebsocketdemo.dto.ChatNotificationDto;
import com.springboot.mswebsocketdemo.entity.ChatMessage;
import com.springboot.mswebsocketdemo.service.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatApiController implements ChatApi {

    private final SimpMessagingTemplate messagingTemplate;

    private final ChatMessageService chatMessageService;

    public ChatApiController(SimpMessagingTemplate messagingTemplate, ChatMessageService chatMessageService) {
        this.messagingTemplate = messagingTemplate;
        this.chatMessageService = chatMessageService;
    }

    @Override
    public void processMessage(ChatMessage chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                new ChatNotificationDto(
                        savedMsg.getId(),
                        savedMsg.getSenderId(),
                        savedMsg.getRecipientId(),
                        savedMsg.getContent()
                )
        );

    }

    @Override
    public ResponseEntity<List<ChatMessage>> findChatMessages(String senderId, String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));

    }
}
