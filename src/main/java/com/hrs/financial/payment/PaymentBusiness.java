package com.hrs.financial.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hrs.financial.payment.bean.PaymentBean;
import com.hrs.financial.payment.bean.QueryParams;
import com.hrs.financial.payment.bean.QueryResult;
import com.hrs.financial.util.Constan;
import com.hrs.financial.util.bean.ResultBean;


@Service("com.hrs.financial.payment.paymentBusiness")
public class PaymentBusiness {
	
	
	@Autowired
	private PaymentDao dao;
	
	public QueryResult queryUserPayment(QueryParams params){
		QueryResult result = null;
		try{
			result = new QueryResult(true,"访问数据成功!");
			result.setCurPage(params.getPage());
			result.setCount(dao.queryUserPaymentCount(params));
			result.setPaymentList(dao.queryUserPayments(params));
			result.setPageSize(Constan.pageSize);		
		}catch(Throwable e){
			e.printStackTrace();
			result = new QueryResult(false,"访问服务器数据失败,程序出现异常!");
		}
		return result;
	}
	
	public ResultBean addUserPayment(PaymentBean bean){
		ResultBean result = new ResultBean(true,"保存账单成功!");
		if(bean == null ){
			return new ResultBean(false,"保存失败,请输入新增的帐号明细!");
		}
		if(StringUtils.isEmpty(bean.getTitle())){
			return new ResultBean(false,"保存失败,请输入标题!");
		}
		if(bean.getPay_money() == null){
			return new ResultBean(false,"保存失败,请输入金额!");
		}
		if(StringUtils.isEmpty(bean.getPay_date())){
			return new ResultBean(false,"保存失败,请输入付款时间!");
		}
		 dao.addUserPayment(bean);
		return result;
	}
	


	

}
