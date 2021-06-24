package com.stp.bpalert;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpmodel")
public class BPAlertModel {

	@Id
	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "business_partner")
	private String businessPartner;

	@Column(name = "delivery_date_1")
	private Date deliveryDate1;

	@Column(name = "delivery_date_2")
	private Date deliveryDate2;

	@Column(name = "delivery_date_3")
	private Date deliveryDate3;

	@Column(name = "delivery_date_4")
	private Date deliveryDate4;

	@Column(name = "delivery_date_5")
	private Date deliveryDate5;

	@Column(name = "delivery_date_6")
	private Date deliveryDate6;

	@Column(name = "next_delivery_date")
	private Date nextDeliveryDate;

	@Column(name = "person_in_charge")
	private String personInCharge;
	  
	@Column(name = "email_of_person_in_charge")
	private String emailOfPersonInCharge;

	public BPAlertModel() {
	}

	public BPAlertModel(String orderNumber, String productName, 
		  String businessPartner, Date deliveryDate1, Date deliveryDate2, 
		  Date deliveryDate3, Date deliveryDate4, Date deliveryDate5,
		  Date deliveryDate6, Date nextDeliveryDate, String personInCharge,
		  String emailOfPersonInCharge) {
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.businessPartner = businessPartner;
		this.deliveryDate1 = deliveryDate1;
		this.deliveryDate2 = deliveryDate2;
		this.deliveryDate3 = deliveryDate3;
		this.deliveryDate4 = deliveryDate4;
		this.deliveryDate5 = deliveryDate5;
		this.deliveryDate6 = deliveryDate6;
		this.nextDeliveryDate = nextDeliveryDate;
		this.personInCharge = personInCharge;
		this.emailOfPersonInCharge = emailOfPersonInCharge;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	public Date getDeliveryDate1() {
		return deliveryDate1;
	}

	public void setDeliveryDate1(Date deliveryDate1) {
		this.deliveryDate1 = deliveryDate1;
	}

	public Date getDeliveryDate2() {
		return deliveryDate2;
	}

	public void setDeliveryDate2(Date deliveryDate2) {
		this.deliveryDate2 = deliveryDate2;
	}

	public Date getDeliveryDate3() {
		return deliveryDate3;
	}

	public void setDeliveryDate3(Date deliveryDate3) {
		this.deliveryDate3 = deliveryDate3;
	}

	public Date getDeliveryDate4() {
		return deliveryDate4;
	}

	public void setDeliveryDate4(Date deliveryDate4) {
		this.deliveryDate4 = deliveryDate4;
	}

	public Date getDeliveryDate5() {
		return deliveryDate5;
	}

	public void setDeliveryDate5(Date deliveryDate5) {
		this.deliveryDate5 = deliveryDate5;
	}

	public Date getDeliveryDate6() {
		return deliveryDate6;
	}

	public void setDeliveryDate6(Date deliveryDate6) {
		this.deliveryDate6 = deliveryDate6;
	}

	public Date getNextDeliveryDate() {
		return nextDeliveryDate;
	}

	public void setNextDeliveryDate(Date nextDeliveryDate) {
		this.nextDeliveryDate = nextDeliveryDate;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getEmailOfPersonInCharge() {
		return emailOfPersonInCharge;
	}

	public void setEmailOfPersonInCharge(String emailOfPersonInCharge) {
		this.emailOfPersonInCharge = emailOfPersonInCharge;
	}
	
	@Override
	  public String toString() {
	    return "BP Alert [orderNumber=" + orderNumber + ", productName=" 
	  + productName +  ", businessPartner=" + businessPartner 
	  + ", deliveryDate1=" + deliveryDate1 
	  + ", deliveryDate2=" + deliveryDate2 
	  + ", deliveryDate3=" + deliveryDate3 
	  + ", deliveryDate4=" + deliveryDate4 
	  + ", deliveryDate5=" + deliveryDate5 
	  + ", deliveryDate6=" + deliveryDate6
	  + ", nextDeliveryDate=" + nextDeliveryDate 
	  + ", personInCharge=" + personInCharge
	  + ", emailOfPersonInCharge=" + emailOfPersonInCharge + "]";
	  }
	
}
