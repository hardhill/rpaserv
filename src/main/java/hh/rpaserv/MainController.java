package hh.rpaserv;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Controller
public class MainController {
    Set<String> mySet = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

    @MessageMapping("/botmessage")
    @SendTo("/pool/messages")
    public Message getBotMessages(SimpMessageHeaderAccessor ha, Message message) {
        String sessionId = ha.getSessionId();
        Map<String, Object> attrs = ha.getSessionAttributes();
        Object ip = ha.getSessionAttributes().get("ip");
        message.setId(sessionId);
        message.setBotip(ip.toString());
        System.out.println(message);
        System.out.println(mySet.size());
        return message;
    }


    @EventListener
    private void onSessionConnectedEvent(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        mySet.add(sha.getSessionId());
    }

    @EventListener
    private void onSessionDisconnectEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        mySet.remove(sha.getSessionId());
    }
}
