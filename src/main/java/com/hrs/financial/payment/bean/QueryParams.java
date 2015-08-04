package com.hrs.financial.payment.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryParams {

	private int page = 1;
	
	private int user_id;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public static  void main(String args[]){
		System.out.println(new SimpleDateFormat("yyyyMMddSSSS").format(new Date()));
	}
	
	
}
