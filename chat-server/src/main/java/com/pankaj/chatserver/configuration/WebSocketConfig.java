package com.pankaj.chatserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // chat client will use this to connect to the server
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // Set prefix for the endpoint that the client listens for our messages from
        // These are endpoints the client can subscribes to.
        registry.enableSimpleBroker("/topic/");

        // Set prefix for endpoints the client will send messages to
        // Message received with this prefixes will be automatically router to controllers @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");

        
    }

}
