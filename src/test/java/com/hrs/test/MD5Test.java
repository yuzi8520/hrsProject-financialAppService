package com.hrs.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
	
	public static void main(String args[]) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		System.out.println(md5.digest(new String("黄大仙").getBytes()).length);
	}

}
