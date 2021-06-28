package com.stp.bpalert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      jdbcTemplate.query("SELECT order_number, product_name, business_partner, "
      		+ "delivery_date_1, delivery_date_2, delivery_date_3, "
      		+ "delivery_date_4, delivery_date_5, delivery_date_6, "
      		+ "next_delivery_date, person_in_charge, "
      		+ "email_of_person_in_charge FROM bpmodel",
        (rs, row) -> new BPAlertModel(
        	rs.getString(1),
        	rs.getString(2),
        	rs.getString(3),
      		rs.getDate(4),
        	rs.getDate(5),
        	rs.getDate(6),
        	rs.getDate(7),
        	rs.getDate(8),
        	rs.getDate(9),
        	rs.getDate(10),
        	rs.getString(11),
        	rs.getString(12))
		
      ).forEach(bpAlertModel -> log.info("Found <" + bpAlertModel + "> in the database."));
    }
  }
}