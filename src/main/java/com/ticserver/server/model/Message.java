package com.ticserver.server.model;

import lombok.Data;

@Data
public class Message {
    String receiver;
    String messageContent;
    String bodyId;
    String sender;
}
