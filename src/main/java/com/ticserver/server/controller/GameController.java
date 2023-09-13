package com.ticserver.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.ticserver.server.model.Message;

@Controller
public class GameController {

    @Autowired
    SimpMessagingTemplate template;

    // public message
    @MessageMapping("/move")
    @SendTo("/gameRoom/public")
    public Message receivedMoves(@Payload Message message) {
        return message;
    }

    // private message

    @MessageMapping("/sendMessageToPrivateRoom")

    public void recvivedGameState(@Payload Message message) {
        int roomId = message.getRoomId();
        String destination = "/private/" + roomId;
        System.out.println(message.getMessageContent());
        template.convertAndSend(destination, message);

    }
}
