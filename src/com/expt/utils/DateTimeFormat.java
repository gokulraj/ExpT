package com.expt.utils;
import java.util.*;
import java.text.*;

public class DateTimeFormat {

	SimpleDateFormat ft;
	public static final String DB_FORMAT="yyyy-MM-dd";
	public static final String DB_DATETIEM_FORMAT="yyyy-MM-dd hh:mm:ss";

	public void setFormat(String f){
		this.ft = new SimpleDateFormat(f);
	}
	public DateTimeFormat(String f){
		setFormat(f);
	}

	public String convertDate(Date d){
		return ft.format(d);

	}

	public String convertToGMT(Date d){
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		ft.setTimeZone(gmtTime);
		return ft.format(d);
	}

	public String getCurrentTimeInGMT(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return convertToGMT(calendar.getTime());
	}
	
}