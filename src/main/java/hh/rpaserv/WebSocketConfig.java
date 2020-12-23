package hh.rpaserv;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void configureMessageBroker(MessageBrokerRegistry confi) {
        confi.enableSimpleBroker("/pool");
        confi.setApplicationDestinationPrefixes("/app");
    }

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/wsrpa")
                .addInterceptors(new IpHandshakeInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();

    }


}
