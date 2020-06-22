package com.mint.financial.webscoket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class CardSchemerWebAPICollectorHandler extends AbstractWebSocketHandler{
	
	     @Override
	    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
	        System.out.println("error occured at sender " + session + " " + throwable);
	    }

	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	      System.out.printf("Session %s closed because of %s" + " "+ session.getId() + " "+ status.getReason());
	    }

	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	         System.out.println("Connected ... " + session.getId()) ;
	    }
 @Override
public void handleMessage(WebSocketSession session,WebSocketMessage<?> message) {
      System.out.println(message.getPayload());	
   }
 
}

































