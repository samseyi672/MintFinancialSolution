package com.mint.financial.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Payload {
	
 private String type ;
 
 private String bank ;
 
 @Field(name="cardnumber")
 private String cardNumber  ;
 
 @Field(name="cardcount")
 private String cardCount  ;
 
public String getCardCount() {
	return cardCount;
}
public void setCardCount(String cardCount) {
	this.cardCount = cardCount;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBank() {
	return bank;
}
public void setBank(String bank) {
	this.bank = bank;
}
public String getCardnumber() {
	return cardNumber;
}
public void setCardnumber(String cardnumber) {
	this.cardNumber = cardnumber;
}
 
}