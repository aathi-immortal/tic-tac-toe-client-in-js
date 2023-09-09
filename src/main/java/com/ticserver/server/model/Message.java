package com.ticserver.server.model;

import lombok.Data;

@Data
public class Message {
    String reciver;
    String messageContent;
    int roomId;
    String sender;
}
