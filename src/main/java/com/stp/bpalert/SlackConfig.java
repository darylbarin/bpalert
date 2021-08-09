package com.stp.bpalert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfig {
	
	@Value("${slack_token}")
	private String slackToken;
	
	@Value("${slack_channel}")
	private String slackChannel;
	
	public String getSlackToken() {
		return slackToken;
	}

	public void setSlackToken(String slackToken) {
		this.slackToken = slackToken;
	}

	public String getSlackChannel() {
		return slackChannel;
	}

	public void setSlackChannel(String slackChannel) {
		this.slackChannel = slackChannel;
	}


}
