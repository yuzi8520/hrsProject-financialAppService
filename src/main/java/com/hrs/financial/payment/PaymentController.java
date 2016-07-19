package com.hrs.financial.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrs.financial.payment.bean.PaymentBean;
import com.hrs.financial.payment.bean.QueryParams;
import com.hrs.financial.payment.bean.QueryResult;
import com.hrs.financial.util.bean.ResultBean; 



@Controller("com.hrs.financial.payment.paymentController")
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentBusiness service;
	
	@RequestMapping(params="action=query")
	@ResponseBody
	public QueryResult queryPayments(QueryParams params){
		return service.queryUserPayment(params);
	}
	
	@RequestMapping(params="action=add")
	@ResponseBody
	public ResultBean addBill(PaymentBean paymentBean){
		return service.addUserPayment(paymentBean);
	}
	
	@RequestMapping(params="action=delete")
	@ResponseBody
	public ResultBean deletePayment(@RequestParam(defaultValue="0") int id){
		return service.deleteUserPayment(id);
	}
	
	

}
