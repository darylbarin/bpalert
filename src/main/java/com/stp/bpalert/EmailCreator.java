package com.stp.bpalert;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailCreator {

	private EmailConfig emailConfig;
	
	public EmailCreator(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}
	
	public void sendAdjustmentEmail(BPAlertModel bpAlertModel) {
		
		//create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		//create mail
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(bpAlertModel.getEmailOfPersonInCharge());
		mailMessage.setFrom("testingCSV@gmail.com"); //CHANGE AFTER TEST
		mailMessage.setSubject("Order adjustment alert " + bpAlertModel.getProductName());
		mailMessage.setText("Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate());
		
		//send
		mailSender.send(mailMessage);
		
	}
	
	public void sendOrderingAlertEmail(BPAlertModel bpAlertModel) {
		
		//create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		//create mail
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(bpAlertModel.getEmailOfPersonInCharge());
		mailMessage.setFrom("testingCSV@gmail.com"); //CHANGE AFTER TEST
		mailMessage.setSubject("Order alert " + bpAlertModel.getProductName());
		mailMessage.setText("Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate());
		
		//send
		mailSender.send(mailMessage);
		
	}
	
	public void sendDeliveryAlertEmail(BPAlertModel bpAlertModel) {
		
		//create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		//create mail
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(bpAlertModel.getEmailOfPersonInCharge());
		mailMessage.setFrom("testingCSV@gmail.com"); //CHANGE AFTER TEST
		mailMessage.setSubject("Delivery alert " + bpAlertModel.getProductName());
		mailMessage.setText("Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate());
		
		//send
		mailSender.send(mailMessage);
		
	}
}
