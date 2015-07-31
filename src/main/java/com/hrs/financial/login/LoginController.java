package com.hrs.financial.login;

import java.util.List;

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
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		List<Integer> list = template.queryForList("select id from kf_admin_user  where userid=? and psw=?",
											Integer.class, userBean.getUserName(),userBean.getPassword());		
		if(list.size() == 0 ){
			return new ResultBean(false,"登录失败,帐号或密码错误!");
		}
		ResultBean result = new ResultBean(true,"登录成功!");
		result.setId(list.get(0));
		return result;
	}
	
	
}
