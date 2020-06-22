package com.mint.financial.controller.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mint.financial.MintFinancialSolutionApplication;
import com.mint.financial.entity.CardDetails;
import com.mint.financial.entity.CardScheme;
import com.mint.financial.service.CardService;

@RestController
@RequestMapping("/cardscheme")
@CrossOrigin
public class CardSchemeRestController {
	private static final Logger log = LoggerFactory.getLogger(MintFinancialSolutionApplication.class);
	
	 @Autowired
	CardService cardService ;
	
	  @GetMapping("/format/verify/{cardNumber}") //
	public CardScheme getCardDetailsByNumber(@PathVariable String cardNumber){
		     // calling the service 
			CardScheme card  =  cardService.findCardDetails("https://lookup.binlist.net", cardNumber)  ;
		   System.out.println("printing  out the api result");
		   log.info(card.toString());
      ResponseEntity<CardScheme> response = new ResponseEntity<CardScheme>(card,HttpStatus.OK) ;
		   return  card ;
		}
	  @GetMapping("/verify/{cardNumber}") //
		public ResponseEntity<?> getCardDetailsFormat(@PathVariable String cardNumber){
			     // calling the service 
				CardDetails details  =  cardService.findCardDetailsFormatted("https://lookup.binlist.net", cardNumber)  ;			
			   System.out.println("printing  out the api result");
			   System.out.println(details);
	      ResponseEntity<CardDetails> response = new ResponseEntity<CardDetails>(details,HttpStatus.OK) ;
			   return  response ;
			}
	    @GetMapping("")
	 public ResponseEntity<?> seenPath(){
		  return new ResponseEntity<String>("seen",HttpStatus.OK) ; 
	 } 
}

