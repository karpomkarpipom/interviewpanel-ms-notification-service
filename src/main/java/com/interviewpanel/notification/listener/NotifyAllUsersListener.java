package com.interviewpanel.notification.listener;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.interviewpanel.notification.kafka.KafkaReceiver;
import com.interviewpanel.notification.processor.NotificationProcessor;
import com.interviewpanel.notification.service.EmailService;
import com.interviewpanel.notification.service.repo.UserRepository;
import com.interviewpanel.user.bean.User;

import java.util.*;

@Component
public class NotifyAllUsersListener {

	  private static final Logger LOGGER = LoggerFactory.getLogger(NotifyAllUsersListener.class);
        
	  @Autowired
	  UserRepository userRepository;
	    
	    private CountDownLatch latch = new CountDownLatch(1);

	    @Autowired
	    private EmailService emailService;
	   
	   @StreamListener("newquestionposted")
	   public void receive(String payload) {
	   	System.out.println("------------------>New question posted successfully!<--------------");
	       LOGGER.info("received payload='{}'", payload);
	       //Call mongo to get all the users list
	       List<User> userLst=userRepository.findAll();
	       String[] users=userLst.stream().map(user-> user.getEmail()).toArray(String[]::new);
	       //String[] users = new String[] {"selvapandy.m@gmail.com","asuhearts@gmail.com"};
	       emailService.sendEmailToMultipleUsers(users,payload);
	       latch.countDown();
	   }
}
