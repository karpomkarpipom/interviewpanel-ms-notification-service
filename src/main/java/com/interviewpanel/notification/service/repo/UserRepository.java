package com.interviewpanel.notification.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.interviewpanel.user.bean.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
