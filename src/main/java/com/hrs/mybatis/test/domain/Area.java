package com.hrs.mybatis.test.domain;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrs.mybatis.test.dao.AreaDao;

public class Area implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name ;
	
	private Long id ;
	
	private String code ;
	
	private String abb;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbb() {
		return abb;
	}

	public void setAbb(String abb) {
		this.abb = abb;
	}
	
	
	public static void main(String args[]){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "springContext.xml" });  
		System.out.println(context.getBean(AreaDao.class).findStudentByStuSequence("gz", "120101485763")
				.getName());
	}

}
