package com.interviewpanel.notification.listener;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.interviewpanel.notification.processor.NotificationProcessor;
import com.interviewpanel.notification.service.EmailService;
import com.interviewpanel.user.bean.User;

@Component
public class NewUserListener {
	  private static final Logger LOGGER = LoggerFactory.getLogger(NewUserListener.class);

	    private CountDownLatch latch = new CountDownLatch(1);

	    @Autowired
	    private EmailService emailService;
	   
	   @StreamListener("usercreated")
	   public void receive(User payload) {
	    	System.out.println("------------------><--------------");
	        LOGGER.info("received payload='{}'", payload);
	        emailService.sendEmailToUser(payload);
	        latch.countDown();
	    }
}
