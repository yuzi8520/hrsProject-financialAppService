package com.hrs.financial.util.bean;

public class ResultBean {
	
	public ResultBean(){}
	
	public ResultBean(boolean success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	private boolean success;
	private String msg;
	private Integer id;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
