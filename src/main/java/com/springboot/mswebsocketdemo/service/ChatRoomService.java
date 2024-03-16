package com.springboot.mswebsocketdemo.service;

import java.util.Optional;

public interface ChatRoomService {

    /**
     * Get the ChatRoom id
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @param createNewRoomIfNotExists a boolean that controls whether a room should be created or not
     * @return a String
     */
    Optional<String> getChatRoomId(String senderId,
                                   String recipientId,
                                   boolean createNewRoomIfNotExists
    );

    /**
     * Create a chat id
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return a String
     */
    String createChatId(String senderId, String recipientId);
}
