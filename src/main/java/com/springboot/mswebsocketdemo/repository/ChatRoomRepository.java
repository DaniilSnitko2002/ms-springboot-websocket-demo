package com.springboot.mswebsocketdemo.repository;

import com.springboot.mswebsocketdemo.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

    /**
     * Find the chatroom by the 2 users
     * @param senderId the sender id
     * @param recipientId the recipient id
     * @return the ChatRoom
     */
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
