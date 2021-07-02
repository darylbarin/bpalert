package com.stp.bpalert;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BPAlertWriter implements ItemWriter<BPAlertModel>{
	
	@Autowired
	private BPAlertRepository bpAlertRepository;

	@Override
	public void write(List<? extends BPAlertModel> items) throws Exception {
		bpAlertRepository.save(items.get(0));
		
	}

}
