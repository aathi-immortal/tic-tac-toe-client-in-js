package com.ticserver.server.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ticserver.server.model.Message;

@Controller
public class GameController {
    @MessageMapping("/move")
    @SendTo("/gameRoom/public")
    public Message receivedMoves(@Payload Message message)
    {
        return message;
    }
}
