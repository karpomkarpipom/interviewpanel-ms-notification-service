package com.interviewpanel.notification.service;

import com.interviewpanel.user.bean.User;

public interface EmailService {
	void sendSimpleMessage(User input);
	String sendEmailToUser(User input);
	String sendEmailToMultipleUsers(String[] usersList,String questionPostedBy);
}
