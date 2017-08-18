package com.consumerai.communication.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SingleSMSResponse {

	private Integer serverCode ;
	private String message;   
    private String error ;
    private String exception;
   
    
	public Integer getServerCode() {
		return serverCode;
	}


	public void setServerCode(Integer serverCode) {
		this.serverCode = serverCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}


	@Override
	public String toString() {
		return "SingleSMSResponse [serverCode=" + serverCode + ", message="
				+ message + ", error=" + error + ", exception=" + exception
				+ "]";
	}

	
	
}
