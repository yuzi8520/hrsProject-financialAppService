package com.hrs.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestLogin {
	
	public static void main(String args[]){
		CloseableHttpClient  httpClient = HttpClients.createDefault() ;
		HttpPost post = new HttpPost("http://localhost:8080/mvc/login");
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("userName","黄如生"));
		list.add(new BasicNameValuePair("password","1234567"));
		try {
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list,"UTF-8");
			post.setEntity(formEntity);
			try {
				CloseableHttpResponse response = httpClient.execute(post);
				HttpEntity responseEntity = response.getEntity();
				System.out.println(EntityUtils.toString(responseEntity, "utf-8"));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

}
