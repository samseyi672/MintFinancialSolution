package com.mint.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MintFinancialSolutionApplication {

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
}
