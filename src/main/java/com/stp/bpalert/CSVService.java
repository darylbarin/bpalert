package com.stp.bpalert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
  @Autowired
  BPAlertRepository repository;

  public void save(MultipartFile file) throws ParseException {
	  try {
		  List<BPAlertModel> bpAlertModel = CSVHelper.csvToBPAlertModel(file.getInputStream());
	      repository.saveAll(bpAlertModel);
	  } catch (IOException e) {
		  throw new RuntimeException("fail to store csv data: " + e.getMessage());
	  }
  }

  public ByteArrayInputStream load() {
    List<BPAlertModel> bpAlertModel = repository.findAll();

    ByteArrayInputStream in = CSVHelper.BPAlertModelToCSV(bpAlertModel);
    return in;
  }

  public List<BPAlertModel> getAllTutorials() {
    return repository.findAll();
  }
}
