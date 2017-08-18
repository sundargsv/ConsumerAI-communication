package com.consumerai.communication.models;

public class SingleSMSRequest {
	 private String source;
	 private String destination;
	 private String text;

	 public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
	  return destination;
	 }
	 public void setDestination(String destination) {
	  this.destination = destination;
	 }
	 public String getText() {
	  return text;
	 }
	 public void setText(String text) {
	  this.text = text;
	 }
	 
}	 