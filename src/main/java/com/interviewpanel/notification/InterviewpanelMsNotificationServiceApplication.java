package com.interviewpanel.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

import com.interviewpanel.notification.processor.NotificationProcessor;
@EnableEurekaClient
@SpringBootApplication
@EnableBinding(NotificationProcessor.class)
public class InterviewpanelMsNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewpanelMsNotificationServiceApplication.class, args);
	}

}
