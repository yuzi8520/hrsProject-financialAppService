package com.hrs.financial.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hrs.financial.util.bean.UserBean;

@Service("com.hrs.financial.login")
public class LoginBusiness {

	@Autowired
	private LoginDao dao;
	
	public LoginResult login(UserBean userBean){
		LoginResult result = new LoginResult(true,"登录成功!");
		try{
			if(userBean == null ){
				return new LoginResult(false,"登录失败,参数为空!");
			}
			if(StringUtils.isEmpty(userBean.getUserAccount())){
				return new LoginResult(false,"登录失败,请输入你的帐号!");
			}
			if(StringUtils.isEmpty(userBean.getPassword())){
				return new LoginResult(false,"登录失败,请输入你的密码!");
			}
			UserBean loginBean = dao.getUserBean(userBean);
			if(loginBean == null ){
				return new LoginResult(false,"登录失败,请输入你的帐号或密码错误!");
			}
			result.setUser(loginBean);
			return result;			
		}catch(Throwable e){
			e.printStackTrace();
			return new LoginResult	(false,"登录失败,服务器程序异常!");
		}
	}
	
}
