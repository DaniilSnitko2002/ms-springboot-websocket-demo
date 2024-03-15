package com.springboot.mswebsocketdemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatNotificationDto {

    /**
     * The id
     */
    private String id;

    /**
     * The sender id
     */
    @NotBlank(message = "sender id is mandatory")
    private String senderId;

    /**
     * The recipient id
     */
    @NotBlank(message = "recipient id is mandatory")
    private String recipientId;

    /**
     * The content
     */
    @NotBlank(message = "content is mandatory")
    private String content;
}
