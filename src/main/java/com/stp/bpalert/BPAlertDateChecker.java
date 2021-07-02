package com.stp.bpalert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BPAlertDateChecker {
	
	public String formatToSimpleDate(Date date1) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date1);
	}

	public long checkDifference(Date date1, Date date2) {
	    long diff = date1.getTime() - date2.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
