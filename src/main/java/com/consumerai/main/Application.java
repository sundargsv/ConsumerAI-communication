package com.consumerai.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.consumerai.communication.api.SingleSMS;
import com.consumerai.communication.models.SingleSMSResponse;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
 
 @SuppressWarnings("unused")
 public static void main(String[] args) {

  
  SpringApplication.run(Application.class, args);
  System.out.println(" Application started to Send SMS ");

  /* 
  * Auth_id, Auth_token are the parameters needed to be passed to initialize SingleSMS class
  * sourceNumber, DestinationNumber, MessageTxt are the parameters needed to be passed to singleSMS.sendSingleSMS(sourceNumber, DestinationNumber,     	 *MessageTxt)
  **/

  /*
  * Please get Auth_id and Auth_token from plivo website
  */
  SingleSMS singleSMS = new SingleSMS("", "");
  SingleSMSResponse res = singleSMS.sendSingleSMS("+14082034735", "+919688265787", "Dear Customer, 1234 is your one-time password (OPT). Please enter the OPT to proceed. Thank you Team Bozucu.");
  System.out.println(res.toString());
}

}
