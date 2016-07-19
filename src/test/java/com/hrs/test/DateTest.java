package com.hrs.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTest {
	
	public static void main(String args[]){

		Calendar ct = Calendar.getInstance();
		ct.add(Calendar.HOUR, 2);
		//int i = date.getTimezoneOffset();
		int i = -(ct.get(Calendar.ZONE_OFFSET) + ct.get(Calendar.DST_OFFSET)) / (60 * 1000);  
		String s=new SimpleDateFormat("yyMMDDHHmmss", Locale.US).format(ct.getTime()),s1;
		System.out.println(s);
		System.out.println(i);
		System.out.println(ct.getTime().getTime());
		System.out.println(ct.getTime().getTime()% 1000L);
		
		System.out.println((int)((ct.getTime().getTime() % 1000L) / 100L));
		if(i <= 0)
			s1 = s2c((Math.abs(i) + 1) / 15) + "+";
		else
			s1 = s2c((i + 1) / 15) + "-";
		s = s + (int)((ct.getTime().getTime() % 1000L) / 100L) + s1;
		
		System.out.println(s);
		
		//submit.setValId_Time(s);
	
	}
	
	public static String s2c(int i){
		int j = i % 100;
		if(j < 10)
			return "0" + j;
		else
			return "" + j;
	}

}
