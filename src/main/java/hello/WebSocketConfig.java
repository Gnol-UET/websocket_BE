package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
        public void configureMessageBroker(MessageBrokerRegistry config) {
        //Broker la dia chi tuong doi: no giong message mapping
        config.enableSimpleBroker("/topic/greetings");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Endpoint la dia chi tuong doi: no giong message mapping
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }

}