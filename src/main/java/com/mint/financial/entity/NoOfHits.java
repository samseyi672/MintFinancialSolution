package com.mint.financial.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//this  is to monitor the no  of hits 
@Document(collection="atmscheme")
public class NoOfHits {
	
@Id
private String id ;

private String size ;

@Field(name="payload")
private Payload payLoad ;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public Payload getPayload() {
	return payLoad;
}
public void setPayload(Payload payload) {
	this.payLoad = payLoad;
}

}







































































































