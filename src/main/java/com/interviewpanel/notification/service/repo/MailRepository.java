package com.interviewpanel.notification.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.interviewpanel.notification.bean.Mail;

public interface MailRepository extends MongoRepository<Mail, Long> {

}