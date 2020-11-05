package com.interviewpanel.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interviewpanel.notification.service.EmailService;
import com.interviewpanel.user.bean.User;

@RestController
public class SendNotificationController {
	
	@Autowired
	EmailService emailService;

	@PostMapping("/v1/sendNotification")
	public String sendNotification(@RequestBody User user) {
		
		String result = emailService.sendEmailToUser(user);
		
		return "Mail sent successfully to "+ user.getEmail();
		
	}
	

	@PostMapping("/v1/multi/notification")
	public String sendMultiNotification(@RequestBody String questionPostedBy) {
		 String[] users = new String[] {"selvapandy.m@gmail.com","asuhearts@gmail.com"};
		String result = emailService.sendEmailToMultipleUsers(users, questionPostedBy);
		
		return "Mail sent successfully to multiple users";
		
	}
}
