package com.hrs.financial.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrs.financial.payment.bean.QueryParams;
import com.hrs.financial.payment.bean.QueryResult; 



@Controller("com.hrs.financial.payment.paymentController")
@RequestMapping("payment")
public class PaymentController {
	
	
	@RequestMapping(params="action=query")
	public QueryResult queryPayments(QueryParams params){
		QueryResult result = new QueryResult();
		
		return result;
		
	}
	
	

}
