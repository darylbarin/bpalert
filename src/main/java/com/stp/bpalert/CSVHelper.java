package com.stp.bpalert;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Order Number", "Product Name",
			"Business Partner", "Delivery Date 1",
			"Delivery Date 2", "Delivery Date 3",
			"Delivery Date 4", "Delivery Date 5",
			"Delivery Date 6", "Next Scheduled Ordered Date",
			"Person In Charge", "Email of Person in Charge"};
	
	public static boolean hasCSVFormat(MultipartFile file) {
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }
	    return false;
	}
	
	public static List<BPAlertModel> csvToBPAlertModel(InputStream is) throws ParseException {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<BPAlertModel> bpAlertModelList = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      
	      DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
	      System.out.println(csvRecords);
	      
	      for (CSVRecord csvRecord : csvRecords) {
	    	  BPAlertModel bpAlertModel = new BPAlertModel(
	    			  csvRecord.get("Order Number"),
		              csvRecord.get("Product Name"),
		              csvRecord.get("Business Partner"),
		              format.parse(csvRecord.get("Delivery Date 1")),
		              format.parse(csvRecord.get("Delivery Date 2")),
		              format.parse(csvRecord.get("Delivery Date 3")),
		              format.parse(csvRecord.get("Delivery Date 4")),
		              format.parse(csvRecord.get("Delivery Date 5")),
		              format.parse(csvRecord.get("Delivery Date 6")),
		              format.parse(csvRecord.get("Next Scheduled Ordered Date")),
		              csvRecord.get("Person In Charge"),
		              csvRecord.get("Email of Person in Charge")
	            );
	    	  bpAlertModelList.add(bpAlertModel);
	      }

	      return bpAlertModelList;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	}
	
	public static ByteArrayInputStream BPAlertModelToCSV(List<BPAlertModel> bpAlertModelList) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (BPAlertModel bpAlertModel : bpAlertModelList) {
	        List<String> data = Arrays.asList(
	              bpAlertModel.getOrderNumber(),
	              bpAlertModel.getProductName(),
	              bpAlertModel.getBusinessPartner(),
	              String.valueOf(bpAlertModel.getDeliveryDate1()),
	              String.valueOf(bpAlertModel.getDeliveryDate2()),
	              String.valueOf(bpAlertModel.getDeliveryDate3()),
	              String.valueOf(bpAlertModel.getDeliveryDate4()),
	              String.valueOf(bpAlertModel.getDeliveryDate5()),
	              String.valueOf(bpAlertModel.getDeliveryDate6()),
	              String.valueOf(bpAlertModel.getNextDeliveryDate()),
	              bpAlertModel.getPersonInCharge(),
	              bpAlertModel.getEmailOfPersonInCharge()
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	}

}
