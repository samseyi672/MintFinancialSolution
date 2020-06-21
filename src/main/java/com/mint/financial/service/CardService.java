package com.mint.financial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mint.financial.SSLContextHelper;
import com.mint.financial.entity.CardScheme;

@Service
public class CardService {
	
	  @Autowired
	 RestTemplate template  ;
	 @Autowired
	 SSLContextHelper ssl ;
	public CardScheme findCardDetails(String url , String cardNumber) {
		// create  the card  instance here 
		  ssl.disable();
		 String result = template.getForObject(url+"/"+cardNumber, String.class);	     
		    System.out.println("from "+ result);
		CardScheme card  =   template.getForObject(url+"/"+cardNumber,CardScheme.class) ;
		   return card ;
	}
}