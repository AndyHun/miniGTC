/*
 * MessageDigest.java Sep 16, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class MessageDigestGuide {
	private static final String MD5 = "MD5";
	public static void main(String[] args){
		System.out.println("DEFUALT ENCODING:"+System.getProperty("file.encoding"));
		String message = "你好";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(MD5);
			System.out.println(messageDigest.getProvider().getInfo());
			messageDigest.update(message.getBytes());
			System.out.println(message);
			System.out.println(messageDigest.digest());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
