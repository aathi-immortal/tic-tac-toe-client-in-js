package com.ticserver.server.configuration;

import javax.swing.Spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketCOnfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // The code you've posted appears to be a configuration method in a Spring
        // WebSocket application. This method is used to configure the behavior of the
        // message broker in the application. Let's break down the code snippet:

        // ```java
        // public void configureMessageBroker(MessageBrokerRegistry registry) {
        // registry.setApplicationDestinationPrefixes("/app");
        // registry.enableSimpleBroker("/chatroom");
        // }
        // ```

        // In a Spring WebSocket application, you typically use a message broker to
        // facilitate communication between clients (usually web browsers) and the
        // server. The message broker is responsible for routing messages from senders
        // to receivers, and it can manage various destinations (topics or queues) for
        // messages.

        // Here's an explanation of each line of the code:

        // 1. `registry.setApplicationDestinationPrefixes("/app");`

        // This line configures the prefix that is used to map application destinations.
        // Application destinations are the URLs to which clients can send messages. In
        // this case, messages sent by clients to destinations starting with "/app" will
        // be handled by the application's message handling methods. For example, if a
        // client sends a message to "/app/chat", it will be directed to an appropriate
        // method on the server that handles messages sent to the "/chat" destination.

        // 2. `registry.enableSimpleBroker("/chatroom");`

        // This line enables a simple message broker for the specified destination(s). A
        // simple message broker is a built-in message broker provided by Spring that
        // allows clients to subscribe to topics and receive messages sent to those
        // topics. In this case, the broker is configured with the destination
        // "/chatroom". This means that messages sent to the "/chatroom" destination
        // will be broadcasted to all clients who are subscribed to that destination.

        // For example, if a client subscribes to "/chatroom/messages", it will receive
        // messages sent to that destination by other clients.

        // To summarize, this configuration code sets up a Spring WebSocket application
        // with the following behavior:

        // - Messages sent by clients to destinations starting with "/app" will be
        // directed to appropriate methods in the application for processing.
        // - A simple message broker is enabled with the "/chatroom" destination.
        // Messages sent to this destination will be broadcasted to all clients who have
        // subscribed to it.

        // Keep in mind that Spring's WebSocket support provides more advanced features
        // and options for configuring message brokers and handling messages. This code
        // is just a simplified example of how you might configure the message broker
        // behavior.
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/gameRoom");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // we need a request that end with /game to get the connection to the server
        // over websocket
        registry.addEndpoint("game").setAllowedOriginPatterns("*")
                .withSockJS();

    }

}
