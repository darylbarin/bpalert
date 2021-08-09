package com.stp.bpalert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BPAlertProcessor implements ItemProcessor<BPAlertModel, BPAlertModel> {
	
	private static final Logger log = LoggerFactory.getLogger(BPAlertProcessor.class);
	
	@Value("${dateInterval}")
	private long dateInterval;
	
	@Value("${parameterDate}")
	private String parameterDate;
	
	@Autowired
	SlackConfig slackConfig;
	
	@Override
	public BPAlertModel process(final BPAlertModel bpAlertModel) throws Exception {
		// Format date to compare  
		BPAlertDateChecker dateChecker = new BPAlertDateChecker();
		Date execDate = new SimpleDateFormat("MM/dd/yyyy").parse(parameterDate);
		SlackMessageCreator slackMessageCreator = new SlackMessageCreator(slackConfig);
		
		// Check if date is within interval date for adjustment
		if(dateChecker.checkDifference(bpAlertModel.getNextDeliveryDate(), 
				execDate) <= dateInterval && dateChecker.checkDifference
				(bpAlertModel.getNextDeliveryDate(), execDate) > 0){	
			slackMessageCreator.sendAdjustmentAlert(bpAlertModel);
			
		}
		
		// If next delivery date = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getNextDeliveryDate())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendOrderingAlert(bpAlertModel);
		}
		
		// If delivery date 1 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate1())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		// If delivery date 2 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate2())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		// If delivery date 3 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate3())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		// If delivery date 4 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate4())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		// If delivery date 5 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate5())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		// If delivery date 6 = execution date
		if(dateChecker.formatToSimpleDate(bpAlertModel.getDeliveryDate6())
				.equals(dateChecker.formatToSimpleDate(execDate))){
			slackMessageCreator.sendDeliveryAlert(bpAlertModel);
		}
		
		return bpAlertModel;
	}
	
	

}
