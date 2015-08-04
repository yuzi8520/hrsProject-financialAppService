package com.hrs.financial.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrs.financial.util.bean.UserBean;


@Controller("com.hrs.financial.login.loginController")
public class LoginController {
	
	@Autowired
	private LoginBusiness service;
	
	@RequestMapping("login")
	@ResponseBody
	public LoginResult login(UserBean userBean){
		return service.login(userBean);
	}
	
	
}
