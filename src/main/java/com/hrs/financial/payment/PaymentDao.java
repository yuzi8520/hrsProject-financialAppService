package com.hrs.financial.payment;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.hrs.financial.payment.bean.PaymentBean;
import com.hrs.financial.payment.bean.QueryParams;
import com.hrs.financial.util.Constan;

@Repository("com.hrs.financial.payment.paymentDao")
public class PaymentDao {
	
	
	private JdbcTemplate template;
	
	@Autowired
	public PaymentDao(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	
	
	public List<PaymentBean> queryUserPayments(QueryParams params){
		Assert.notNull(params, "params argument cant not be null !");
		int pageSize = Constan.pageSize;
		
		List<PaymentBean> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from (select id,user_id,title,to_char(pay_date,'yyyy-MM-dd') pay_date,pay_money,pay_comment,")
		   .append("type,type_name,row_number() over(order by pay_date desc,id desc) rn from hrs_lift_financial where user_id=?) ")
		   .append("where rn between ? and ?");
		
		list = template.query(sql.toString(), new BeanPropertyRowMapper<PaymentBean>(PaymentBean.class),
					params.getUser_id(),(params.getPage()-1)*pageSize+1,params.getPage()*pageSize);	
		return list;
	}
	

	public int queryUserPaymentCount(QueryParams params){
		Assert.notNull(params, "params argument cant not be null !");
		return template.queryForObject("select count(1) from hrs_lift_financial where user_id=?", Integer.class, params.getUser_id()); 
	}
	
	public int addUserPayment(PaymentBean bean ){
		Assert.notNull(bean,"argument bean cant not be null !");
		return template.update("insert into HRS_LIFT_FINANCIAL(id,user_id,title,pay_date,pay_money,pay_comment,type,type_name) values(HRS_LIFT_FINANCIAL_seq.nextval,?,?,to_date(?,'yyyy-MM-dd HH24:mi'),?,?,?,?)",
				bean.getUser_id(),bean.getTitle(),bean.getPay_date(),bean.getPay_money(),bean.getPay_comment(),bean.getType(),bean.getType_name());
	}
	
}
