package com.mint.financial.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mint.financial.SSLContextHelper;
import com.mint.financial.entity.CardScheme;
import com.mint.financial.entity.FormattedCardScheme;
import com.mint.financial.entity.CardDetails;

@Service
public class CardService {
	
	  @Autowired
	private RestTemplate template  ;
	 @Autowired
	private SSLContextHelper ssl ;
	  @Autowired
	private  FormattedCardScheme formattedCard  ;
	
	       @Autowired
		private  CardScheme card  ;

	       @Autowired
	   	private  CardDetails details  ;
	       
	public CardScheme findCardDetails(String url , String cardNumber) {
		// create  the card  instance here 
		  ssl.disable();
		 String result = template.getForObject(url+"/"+cardNumber, String.class);	     
		    System.out.println("from "+ result);	  
		CardScheme card  =   template.getForObject(url+"/"+cardNumber,CardScheme.class) ;
		   return card ;
	}
	public CardDetails findCardDetailsFormatted(String url,String cardNumber) {
		// create  the card  instance here 
		  ssl.disable();
		 String result = template.getForObject(url+"/"+cardNumber, String.class);	     
		    System.out.println("from "+ result);
		     card  =   template.getForObject(url+"/"+cardNumber,CardScheme.class) ;
		  //  CardDetails details  =  new CardDetails();
		     details.setSuccess(true);
   // FormattedCardScheme  formattedCard  = new  FormattedCardScheme() ;
        formattedCard.setType(card.getType());
        formattedCard.setScheme(card.getScheme());
        formattedCard.setBank(card.getBank().get("name"));
		     details.setPayLoad(formattedCard);
			   return details ;
	}
}



































































