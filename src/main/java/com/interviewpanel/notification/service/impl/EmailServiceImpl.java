package com.interviewpanel.notification.service.impl;


 
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.interviewpanel.notification.bean.Mail;
import com.interviewpanel.notification.service.EmailService;
import com.interviewpanel.notification.service.repo.MailRepository;
import com.interviewpanel.user.bean.User;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public MailRepository mailRepository;
    
    @Value("${email.subject}")
    private String emailSubject;

    @Override
    public void sendSimpleMessage(User input) {
        try {

            Mail newMail = new Mail();
            newMail.setTo(input.getEmail());
            newMail.setSubject(emailSubject);
            newMail.setText("Hi" +" "+input.getFirstName() +" "+ input.getLastName() +" "+ "you have successfully signup with interviewpanel. Login with your credentials and update your interview question knowledge! Thanks.");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            mailRepository.save(newMail);
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }

    }
    
    public String sendEmailToUser(User input){
        String result =null;
        MimeMessage message =emailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
            String htmlMsg = "<body style='border:2px solid black'>"
                        +"Your onetime password for registration is  " 
                            + "Please use this OTP to complete your new user registration."+
                              "OTP is confidential, do not share this  with anyone.</body>";
            //message.setContent(htmlMsg, "text/html");
            message.setHeader("Content-ID", "<logoimg>");
            message.setContent
            ("<table width=\\\"600\\\" border=\\\"0\\\" cellspacing=\\\"0\\\" cellpadding=\\\"0\\\">  <tr>    "
					+ "<td><b>WELCOME TO INTERVIEWPANEL</b></td>  </tr>  <tr>    "
					+ "<td height=\\\"220\\\"> <p>Thanks for Joining interviewpanel.ga</p>      "
					+ "<p>This site is useful for update the interview questions and answers. "
					+ "Also the users can add their own experienced interview questions and answers !  </p>   "
					+ "<p>Username: "+ input.getEmail() +"<br />      Password: *********</p>    <p>To confirm your email click <a href=\\\"#\\\">here</a>.</p></td>  </tr>  <tr>    "
					+ "<td height=\\\"50\\\" align=\\\"center\\\" valign=\\\"middle\\\" bgcolor=\\\"#CCCCCC\\\">www.interviewpanel.ga | contact@interviewpanel.ga | +1000-000-0000</td>  </tr></table>", 
             "text/html");
            helper.setTo(input.getEmail());
            helper.setSubject(emailSubject);
            result="success";
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }finally {
            if(result !="success"){
                result="fail";
            }
        }

        return result;

    }
    
    public String sendEmailToMultipleUsers(String[] usersList,String questionPostedBy){
        String result =null;
        MimeMessage message =emailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
            message.setHeader("Content-ID", "<logoimg>");
            message.setContent
            ("<table width=\\\"600\\\" border=\\\"0\\\" cellspacing=\\\"0\\\" cellpadding=\\\"0\\\">  <tr>    "
					+ "<td><b>NEW QUESTIONS POSTED TO INTERVIEWPANEL</b></td>  </tr>  <tr>    "
					+ "<td height=\\\"220\\\"> <p>New questions added by "+questionPostedBy+"</p>      "
					+ "<p>Please login to website and check the latest questions. "
					+ "Also the users can add their own experienced interview questions and answers !  </p>   "
					+ "</td>  </tr>  <tr>    "
					+ "<td height=\\\"50\\\" align=\\\"center\\\" valign=\\\"middle\\\" bgcolor=\\\"#CCCCCC\\\">www.interviewpanel.ga | contact@interviewpanel.ga | +1000-000-0000</td>  </tr></table>", 
             "text/html");
            helper.setTo(usersList);
            helper.setSubject(emailSubject);
            result="success";
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }finally {
            if(result !="success"){
                result="fail";
            }
        }

        return result;

    }
}