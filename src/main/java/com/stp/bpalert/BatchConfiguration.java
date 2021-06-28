package com.stp.bpalert;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public FlatFileItemReader<BPAlertModel> reader() {
    return new FlatFileItemReaderBuilder<BPAlertModel>()
      .name("bpAlertModelItemReader")
      .resource(new ClassPathResource("bpalert-sample.csv"))
      .delimited()
      .names(new String[]{"order_number", "product_name", "business_partner", 
    		  "delivery_date_1", "delivery_date_2", "delivery_date_3", 
    		  "delivery_date_4", "delivery_date_5", "delivery_date_6", 
    		  "next_delivery_date", "person_in_charge", "email_of_person_in_charge"})
      .fieldSetMapper(new BeanWrapperFieldSetMapper<BPAlertModel>() {{
        setTargetType(BPAlertModel.class);
      }})
      .build();
  }

  @Bean
  public BPAlertModelProcessor processor() {
    return new BPAlertModelProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<BPAlertModel> writer(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<BPAlertModel>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO bpmodel (order_number, product_name, "
      		+ "business_partner, delivery_date_1, delivery_date_2, "
      		+ "delivery_date_3, delivery_date_4, delivery_date_5, "
      		+ "delivery_date_6, next_delivery_date, person_in_charge, "
      		+ "email_of_person_in_charge) VALUES (:orderNumber, :productName, :businessPartner,"
      		+ ":deliveryDate1, :deliveryDate2, :deliveryDate3, :deliveryDate4, :deliveryDate5, :deliveryDate6,"
      		+ ":nextDeliveryDate, :personInCharge, :emailOfPersonInCharge)")
      .dataSource(dataSource)
      .build();
  }
  
  @Bean
  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
  }

  @Bean
  public Step step1(JdbcBatchItemWriter<BPAlertModel> writer) {
	    return stepBuilderFactory.get("step1")
	      .<BPAlertModel, BPAlertModel> chunk(10)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
  }

}