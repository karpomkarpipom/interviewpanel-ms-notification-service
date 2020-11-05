package com.interviewpanel.notification.kafka;


 
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;

import com.interviewpanel.notification.service.EmailService;
import com.interviewpanel.user.bean.User;

public class KafkaReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

	/*
	 * @KafkaListener(topics = "${spring.kafka.topic.userCreated}" ,groupId =
	 * "ms_mail_consumer",containerFactory = "kafkaListenerContainerFactory") public
	 * void receive(User payload) {
	 * System.out.println("------------------><--------------");
	 * LOGGER.info("received payload='{}'", payload);
	 * emailService.sendEmailToUsers(payload); latch.countDown(); }
	 */
    
    
	
	/*
	 * @StreamListener(target="input") public void receive(User payload) {
	 * System.out.println("------------------><--------------");
	 * LOGGER.info("received payload='{}'", payload);
	 * emailService.sendEmailToUser(payload); latch.countDown(); }
	 */
	 
}
 