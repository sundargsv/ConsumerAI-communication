package com.consumerai.communication.api;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.*;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;
import com.consumerai.communication.models.SingleSMSResponse;

@Configuration
@ComponentScan
public class SingleSMS {
	
	/*
	   * Application : Consumer AI - CommunicationService
	   * Consumer AI - CommunicationService  : Can able to send SMS, Voice call etc.
	   * Single Send SMS - Used for sending the generated OTP to the User Phone number
	   * **/
	
	 private static final Logger LOGGER = Logger.getLogger(SingleSMS.class.getName());
	 private static String AUTH_ID = "";
	 private static String AUTH_TOKEN = "";
	 
	public SingleSMS(String AUTH_ID, String AUTH_Token) {
		super();
		Logger.getLogger(SingleSMS.class.getName());
		this.AUTH_ID = AUTH_ID;
		this.AUTH_TOKEN = AUTH_Token;
	}
	 
	
	 public SingleSMSResponse sendSingleSMS(String sourceNumber, String destinationNumber, String text) {
			System.out.println("Starting to contact Plivo to send SMS...");	 
			SingleSMSResponse response = new SingleSMSResponse();
//	  		String authId = "MAOTY0OGY3NZFKMDI0OG";
//	        String authToken = "Y2I2ZjYyZmM0NmZlYjA5N2FkNzhkNGIxOWU2NTA5";
			MessageResponse msgResponse = new MessageResponse();
			System.out.println(this.AUTH_ID+" "+this.AUTH_TOKEN);
	        RestAPI api = new RestAPI(this.AUTH_ID, this.AUTH_TOKEN, "v1");
	        
	        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
	        parameters.put("src", sourceNumber); // Sender's phone number with country code
	        parameters.put("dst", destinationNumber); // Receiver's phone number with country code
	        parameters.put("text", text); // Your SMS text message
	        
	        try {
	         System.out.println("Trying to send SMS...");
	            // Send the message
	            msgResponse = api.sendMessage(parameters);

	            // Print the response
	            //System.out.println(msgResponse);
	            // Print the Api ID
	            System.out.println("Api ID : " + msgResponse.apiId);
	            // Print the Response Message
	            response.setServerCode(msgResponse.serverCode);
	            response.setMessage(msgResponse.message);
	            if (msgResponse.serverCode == 202) {
	                // Print the Message UUID
	                System.out.println("Message UUID : " + msgResponse.messageUuids.get(0).toString());
	            } else {
	             System.out.println("Warning !!! Plivo responded with different serverCode/ ErrorCode...");
	                response.setError(msgResponse.error);
	            }
	        } catch (PlivoException e) {
	         e.printStackTrace();
	         response.setException("Exception occured in sending message using Plivo!!!");
	        }
	        return response;
	 }
	
	
}
