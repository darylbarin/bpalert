package com.stp.bpalert;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class BPAlertModelProcessor implements ItemProcessor<BPAlertModel, BPAlertModel> {

  private static final Logger log = LoggerFactory.getLogger(BPAlertModelProcessor.class);

  @Override
  public BPAlertModel process(final BPAlertModel item) throws Exception {
	  final String orderNumber = item.getOrderNumber();
	  final String productName = item.getProductName();
	  final String businessPartner = item.getBusinessPartner();
	  final Date deliveryDate1 = item.getDeliveryDate1();
	  final Date deliveryDate2 = item.getDeliveryDate2();
	  final Date deliveryDate3 = item.getDeliveryDate3();
	  final Date deliveryDate4 = item.getDeliveryDate4();
	  final Date deliveryDate5 = item.getDeliveryDate5();
	  final Date deliveryDate6 = item.getDeliveryDate6();
	  final Date nextDeliveryDate = item.getNextDeliveryDate();
	  final String personInCharge = item.getPersonInCharge();
	  final String emailOfPersonInCharge = item.getEmailOfPersonInCharge();
	  
	  //Transform Data here
	  
	  
	  final BPAlertModel bpAlertModel = new BPAlertModel(orderNumber, productName, businessPartner,
			  deliveryDate1, deliveryDate2, deliveryDate3, deliveryDate4, deliveryDate5, deliveryDate6,
			  nextDeliveryDate, personInCharge, emailOfPersonInCharge);
	  
	  log.info("Converting (" + item + ") into (" + bpAlertModel + ")");

    return bpAlertModel;
  }

}