package com.mint.financial.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardScheme {

private HashMap<String,String>   bank  ;
private String type ;
private String scheme ;

public CardScheme(HashMap<String, String> bank, String type, String scheme) {
	super();
	this.bank = bank;
	this.type = type;
	this.scheme = scheme;
}

public CardScheme() {
	super();
}

public HashMap<String, String> getBank() {
	return bank;
}

public void setBank(HashMap<String, String> bank) {
	this.bank = bank;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getScheme() {
	return scheme;
}

public void setScheme(String scheme) {
	this.scheme = scheme;
}

}
