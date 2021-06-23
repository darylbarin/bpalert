package com.stp.bpalert;

import javax.validation.ValidationException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class BPAlertController {

	private EmailConfig emailConfig;
	
	public BPAlertController(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}
	
	@PostMapping
	public void sendEmail(@RequestBody EmailContent emailContent,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Email Content is not valid");
		}
		
		//create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		//create mail
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emailContent.getEmail());
		mailMessage.setFrom("testingCSV@gmail.com"); //CHANGE DEPENDING ON CSV DATA
		mailMessage.setSubject("Email test from " + emailContent.getName().toString()); //CHANGE DEPENDING ON CSV DATA
		mailMessage.setText(emailContent.getMessage());
		
		//send
		mailSender.send(mailMessage);
		
	}
}
