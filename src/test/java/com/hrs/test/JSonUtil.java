package com.hrs.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.hrs.financial.payment.bean.QueryResult;
import com.hrs.financial.util.bean.ResultBean;

public class JSonUtil {

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
	   List<ResultBean> list1 = new ArrayList<ResultBean>();
		list1.add(new ResultBean(true,"11"));
		list1.add(new ResultBean(false,"22"));
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		QueryResult result = new QueryResult();
		result.setCount(10);
		result.setMsg("成功!");
	//result.setCurrPageList(list1);
		//System.out.println(mapper.writeValueAsString(result));
		
		String source = "{\"count\":10,\"success\":false,\"msg\":\"成功!\",\"currPageList\":[{\"success\":true,\"msg\":\"11\"},{\"success\":false,\"msg\":\"22\"}]}";
		
		QueryResult list = mapper.readValue(source,QueryResult.class);
		
		//List<ResultBean> list = mapper.readValue(source, list1.getClass());
		
		
		//System.out.println(list.getCurrPageList().get(1).getMsg());
		
	}
}
