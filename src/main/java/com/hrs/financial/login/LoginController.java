package com.hrs.financial.login;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrs.financial.util.bean.ResultBean;
import com.hrs.financial.util.bean.UserBean;


@Controller("com.hrs.financial.login.loginController")

public class LoginController {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("login")
	@ResponseBody
	public ResultBean login(UserBean userBean){
		System.out.println(userBean);
		//System.out.println(model.get("userName"));
		//System.out.println(dataSource != null);
		JdbcTemplate template = new JdbcTemplate(dataSource);
		System.out.println(template.queryForList("select name from area", String.class));
		return new ResultBean(true,"登录成功!");
	}
	
	
}
