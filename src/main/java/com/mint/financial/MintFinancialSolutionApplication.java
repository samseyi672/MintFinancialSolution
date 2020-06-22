package com.mint.financial;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import com.mint.financial.entity.CardDetails;
import com.mint.financial.entity.CardScheme;
import com.mint.financial.entity.FormattedCardScheme;
import com.mint.financial.webscoket.CardSchemerWebAPICollectorHandler;
import com.mint.financial.webscoket.ClientStreamCaller;

@SpringBootApplication
public class MintFinancialSolutionApplication {
  private static String MEET_ENDPOINTS  = "ws://localhost:8092/cardscheme/verify/5399832609313790" ;
  private static String  CARD_ENDPOINTS  = "ws://stream.meetup.com/2/rsvps" ;
  //private static String MEET_ENDPOINTS2  = "ws://localhost:8091/cardscheme/verify" ;
  
	public static void main(String[] args) {
		SpringApplication.run(MintFinancialSolutionApplication.class, args);
	}
	   @Bean
	   public RestTemplate getRestTemplate() {
	    	
	      return new RestTemplate();
	   }
	    @Bean
	   public SSLContextHelper getSSLContextHelper() {
	    	 return new SSLContextHelper() ;
	    }
	   @Bean
	  public CardScheme getCardScheme() {
		  return new CardScheme() ;  
	   }
	       @Bean
		  public CardDetails getCardDetails() {
			  return new CardDetails() ;  
		   }  
	            @Bean
			  public FormattedCardScheme getFormattedCardScheme() {
				  return new FormattedCardScheme() ;  
			   } 
	                          
//	         @Bean
//		  public CardSchemerWebAPICollectorHandler getCardSchemerWebAPICollectorHandler() {
//		        return  new CardSchemerWebAPICollectorHandler() ;
//		    }
	     @Bean
	   public WebSocketClient getWebSocketClient() {
	    	 return  new StandardWebSocketClient() ;
	     }
	     
	     @Bean
	  public ClientStreamCaller getClientStreamCaller() {
		  return new ClientStreamCaller() ;
	  }
	 	@Bean
	 	public ApplicationRunner initializeConnection(CardSchemerWebAPICollectorHandler handler){
	 		return args -> {
	 			 WebSocketClient cardAPISocket  = new StandardWebSocketClient() ;
	 			 System.out.println(cardAPISocket);
	 			 System.out.println("handler api working also with application runner");
	 			 cardAPISocket.doHandshake(handler, MEET_ENDPOINTS) ;
	 		};
}
}





