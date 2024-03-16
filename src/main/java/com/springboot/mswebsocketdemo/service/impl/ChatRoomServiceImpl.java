package com.springboot.mswebsocketdemo.service.impl;

import com.springboot.mswebsocketdemo.entity.ChatRoom;
import com.springboot.mswebsocketdemo.repository.ChatRoomRepository;
import com.springboot.mswebsocketdemo.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    /**
     * The Constructor
     * @param chatRoomRepository the ChatRoom repository
     */
    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    /**
     * Get the ChatRoom id
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @param createNewRoomIfNotExists a boolean that controls whether a room should be created or not
     * @return a String
     */
    @Override
    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }

                    return  Optional.empty();
                });
    }

    /**
     * Create a chat id
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return a String
     */
    @Override
    public String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;

    }
}
