package com.springboot.mswebsocketdemo.repository;

import com.springboot.mswebsocketdemo.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {

    /**
     * Find the chat by id
     * @param id the id
     * @return a list of messages
     */
    List<ChatMessage> findByChatId(String id);

}
