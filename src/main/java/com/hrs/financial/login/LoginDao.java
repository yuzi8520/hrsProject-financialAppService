package com.hrs.financial.login;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrs.financial.util.bean.UserBean;

@Repository("com.hrs.financial.login.repository")
public class LoginDao {
	
	private JdbcTemplate template;
	
	@Autowired
	public LoginDao(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	
	public UserBean getUserBean(UserBean userBean){
		//System.out.println(userBean);
		//Assert.notNull(userBean, "argument userBean cant not be null !");
		List<UserBean> list = template.query("select id,userid userAccount,psw password,userName from kf_admin_user where userid=? and psw=?",
							new BeanPropertyRowMapper<UserBean>(UserBean.class), userBean.getUserAccount(),userBean.getPassword());
		System.out.println(list.size());
		if(list.size()  >0){
			return list.get(0);
		}
		return null;
	}

}
