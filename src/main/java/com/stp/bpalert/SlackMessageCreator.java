package com.stp.bpalert;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;

public class SlackMessageCreator {

private SlackConfig slackConfig;

private static final Logger log = LoggerFactory.getLogger(SlackMessageCreator.class);
	
	public SlackMessageCreator(SlackConfig slackConfig) {
		this.slackConfig = slackConfig;
	}
	
	public void sendAdjustmentAlert(BPAlertModel bpAlertModel) throws IOException, SlackApiException {
		// Create Slack
		Slack slack = Slack.getInstance();
		
		ChatPostMessageResponse response = slack.methods(slackConfig.getSlackToken()).chatPostMessage(req -> req
				  .channel(slackConfig.getSlackChannel())
				  .text("===== Adjustment Alert ===== \n"
				+ "Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate()));
				if (response.isOk()) {
				  Message postedMessage = response.getMessage();
				  log.info(postedMessage.toString());
				} else {
				  String errorCode = response.getError();
				  log.info(errorCode);
				}
	}
	
	public void sendOrderingAlert(BPAlertModel bpAlertModel) throws IOException, SlackApiException {
		// Create Slack
		Slack slack = Slack.getInstance();
		
		ChatPostMessageResponse response = slack.methods(slackConfig.getSlackToken()).chatPostMessage(req -> req
				  .channel(slackConfig.getSlackChannel())
				  .text("===== Ordering Alert ===== \n"
				+ "Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate()));
				if (response.isOk()) {
				  Message postedMessage = response.getMessage();
				  log.info(postedMessage.toString());
				} else {
				  String errorCode = response.getError();
				  log.info(errorCode);
				}
	}
	
	public void sendDeliveryAlert(BPAlertModel bpAlertModel) throws IOException, SlackApiException {
		// Create Slack
		Slack slack = Slack.getInstance();
		
		ChatPostMessageResponse response = slack.methods(slackConfig.getSlackToken()).chatPostMessage(req -> req
				  .channel(slackConfig.getSlackChannel())
				  .text("===== Delivery Alert ===== \n"
				+ "Order number: " + bpAlertModel.getOrderNumber() + "\n"
				+ "Product name: " + bpAlertModel.getProductName() + "\n"
				+ "Business partner: " + bpAlertModel.getBusinessPartner() + "\n"
				+ "Scheduled next order date: " + bpAlertModel.getNextDeliveryDate()));
				if (response.isOk()) {
				  Message postedMessage = response.getMessage();
				  log.info(postedMessage.toString());
				} else {
				  String errorCode = response.getError();
				  log.info(errorCode);
				}
	}
	
}
