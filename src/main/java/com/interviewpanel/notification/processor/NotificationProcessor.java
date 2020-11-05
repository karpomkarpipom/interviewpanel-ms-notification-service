package com.interviewpanel.notification.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface  NotificationProcessor {

  String USER_CREATED_TOPIC = "usercreated"; // Topic where the
  String NEW_QUESTIONS_POSTED_TOPIC = "newquestionposted"; // Topic where 
  
  @Input
  SubscribableChannel usercreated();
  
  @Input
  SubscribableChannel newquestionposted();
	/*
	 * @Output(APPROVED_OUT) MessageChannel approved();
	 * 
	 * @Output(DECLINED_OUT) MessageChannel declined();
	 */
}