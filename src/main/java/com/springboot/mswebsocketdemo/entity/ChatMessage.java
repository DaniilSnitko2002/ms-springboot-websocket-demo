package com.springboot.mswebsocketdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_message")
public class ChatMessage {
    /**
     * The id
     */
    @Id
    @GeneratedValue(generator = "USERS_ID_SEQ")
    @GenericGenerator(name = "USERS_ID_SEQ", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    /**
     * The chat id
     */
    @NotBlank(message = "chat id is mandatory")
    @Column(name = "chat_id")
    private String chatId;

    /**
     * The sender id
     */
    @NotBlank(message = "sender id is mandatory")
    @Column(name = "sender_id")
    private String senderId;

    /**
     * The recipient id
     */
    @NotBlank(message = "recipient id is mandatory")
    @Column(name = "recipient_id")
    private String recipientId;

    /**
     * The content
     */
    @NotBlank(message = "content id is mandatory")
    private String content;
}
