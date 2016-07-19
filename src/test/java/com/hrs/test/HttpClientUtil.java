package com.hrs.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;



public class HttpClientUtil {
	
	public static void main(String args[]){
		
		Header h = new BasicHeader("Content-Type"," UserID=JohnDoe; Max-Age=3600; Version=1");
		System.out.println("name="+h.getName()+",value="+h.getValue());
		for(HeaderElement e :h.getElements()){
			System.out.println(e.getName()+","+e.getValue());
			for(NameValuePair np : e.getParameters()){
				System.out.println(np.getName()+","+np.getValue());
			}
			
		}
		
//		Header
//		
//		
//		Map<String,String> params = new HashMap<String,String>();
//		params.put("userName", "黄大仙");
//		params.put("password", "123456789");
//		ResultBean bean = HttpClientUtil.doPost("http://localhost:8080/mvc/login", params, ResultBean.class);
//		if(bean != null){
//			System.out.println(bean.getMsg());
//		}
	}
	
	/**
	 * 
	 * @param <T>
	 * @param httpURL
	 * @param requestObject java.util.Map or  bean
	 * @return
	 */
	public static  <T> T doPost(String url,Object requestObject,Class<T> resultClass){
		T result = null;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			
			if(requestObject != null){
				HttpEntity formEntity = createUrlEncodedFormEntity(requestObject);
				if(formEntity != null ){
					post.setEntity(formEntity);
				}
			}
			
			response = httpClient.execute(post); 
			result =  consumeReponse(response,resultClass);// transfer json to bean
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuite(response);
			closeQuite(httpClient);
		}
		return result;
	}
	
	private static void closeQuite(Closeable target){
		if(target != null){
			try {
				target.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static <T>T consumeReponse(CloseableHttpResponse response,Class<T> resultClass){
		 T result = null ;
		 HttpEntity responseEntity = response.getEntity();
		 try {
			 String outJson = EntityUtils.toString(responseEntity, Consts.UTF_8.displayName());
			 ObjectMapper mapper = new ObjectMapper();
			 result = mapper.readValue(outJson,resultClass);
		 } catch (ParseException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }		
	    return result;
	}
	
	private static HttpEntity createUrlEncodedFormEntity(Object requestObject){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if(requestObject instanceof Map){
			Map<?,?> requestMap = (Map<?,?>)requestObject;
			for(Map.Entry<?, ?> entry: requestMap.entrySet()){
				Object key = entry.getKey();
				Object val = entry.getValue();
				if(key != null && val != null){
					params.add(new BasicNameValuePair(key.toString(),val.toString()));
				}
			}			
		}else{//others are regard as bean
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(requestObject.getClass());
				PropertyDescriptor pds[] = beanInfo.getPropertyDescriptors();
				if(pds != null){
					for(PropertyDescriptor pd : pds){
						String name = pd.getName();
						if("class".equals(name)){
							continue;
						}
						Method method = pd.getReadMethod();
						if(method != null){
							Object val = method.invoke(requestObject, new Object[]{});
							if(name != null && val != null){
								params.add(new BasicNameValuePair(name,val.toString()));
							}
						}
					}
				}
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		UrlEncodedFormEntity formEntity = null;
		try {
			formEntity = new UrlEncodedFormEntity(params,Consts.UTF_8.displayName());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formEntity;
	}
	
	
	

}
